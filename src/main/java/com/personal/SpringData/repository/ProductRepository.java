package com.personal.SpringData.repository;

import com.personal.SpringData.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByidBetween(Long start,Long end);
}
