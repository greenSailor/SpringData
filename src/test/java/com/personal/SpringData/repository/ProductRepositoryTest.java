package com.personal.SpringData.repository;

import com.personal.SpringData.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.List;


@SpringBootTest
//@DataJpaTest
// is not required because the SpringBootTest will load the whole context bean to perform CRUD operations.
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testSaveMethod()
    {
        //Create Product
        Product product = new Product();
        product.setName("IPhone 15");
        product.setDescription("Launched on sep 12");
        product.setPrice(new BigDecimal(999));
        product.setActive(false);
        product.setImageUrl("IPhone15.png");
        product.setSku("New Launch");

        //Save Product
        Product savedProduct = productRepository.save(product);

        //display Product Info
        System.out.println(savedProduct);
    }

    //Update existing Product
    @Test
    void updateExistingProduct()
    {
        //retrieve values from the data for Long id 7
        Product retrieve = productRepository.findById(7L).get();

        //update
        retrieve.setSku("Sep 2024 Launch");

        //Save
        Product saved = productRepository.save(retrieve);

        //Display
        System.out.println(saved);
    }

    //Delete By Id
    @Test
    void deleteById()
    {
        Long id = 8L;
        productRepository.deleteById(id);
        List<Product> all = productRepository.findAll();
        all.forEach(product -> System.out.println(product.toString()));

    }

    @Test
    void delete()
    {
        Long id = 7L;
        Product retrive = productRepository.findById(id).get();
        productRepository.delete(retrive);

        List<Product> all =  productRepository.findAll();

        all.forEach(product -> System.out.println(product.getId()));
    }

    @Test
    void findByMethod()
    {
        List<Product> all =  productRepository.findAll();

        all.forEach(product -> System.out.println(product.getId()));
    }

    @Test
    void saveAll()
    {
        Product product = new Product();
        product.setName("IPhone 16");
        product.setDescription("Launched on sep 12");
        product.setPrice(new BigDecimal(999));
        product.setActive(false);
        product.setImageUrl("IPhone15.png");
        product.setSku("Next Launch");

        Product product1 = new Product();
        product1.setName("IPhone 16 Plus");
        product1.setDescription("Launched on sep 12");
        product1.setPrice(new BigDecimal(999));
        product1.setActive(false);
        product1.setImageUrl("IPhone15.png");
        product1.setSku("Next Launch 1");

        Product product2 = new Product();
        product2.setName("IPhone 16 Pro");
        product2.setDescription("Launched on sep 12");
        product2.setPrice(new BigDecimal(999));
        product2.setActive(false);
        product2.setImageUrl("IPhone15.png");
        product2.setSku("Next Launch 2");

        List<Product> all = List.of(new Product[]{product, product1, product2});

        List<Product> savedProduct = productRepository.saveAll(all);

        savedProduct.forEach(productValues -> System.out.println(productValues.getId()));
    }

    @Test
    void deleteAllMethod()
    {
        productRepository.deleteAll();
    }

    @Test
    void deleteAllMethodListOfItems()
    {
        Product item1 = productRepository.findById(9L).get();
        Product item2 = productRepository.findById(10L).get();
        productRepository.deleteAll(List.of(item1,item2));
    }

    @Test
    void countMethod()
    {
        Long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existById()
    {
        Long id = 8L;
        Boolean exists = productRepository.existsById(8L);
        System.out.println(exists);
    }
    @Test
    void findBetween()
    {
        Long startId = 11L;
        Long endId = 15L;
        List<Product> all = productRepository.findByidBetween(startId,endId);
        all.forEach(product -> System.out.println(product.toString()));
    }
    @Test
    void sorting()
    {
        String sortBy = "name";
        String sortDir = "desc";
        String sortByDesc = "description";

        Sort sortName = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():
                Sort.by(sortBy).descending();
        Sort sortDesc = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortByDesc).ascending():
                Sort.by(sortByDesc).descending();

        Sort groupBySort = sortName.and(sortDesc);

        List<Product> products = productRepository.findAll(groupBySort);

        products.forEach(product -> System.out.println(product.toString()));

    }
}