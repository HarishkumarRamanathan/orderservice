package com.example.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.order.entity.OrderEntity;

@Repository
public interface OrderRepostiory extends JpaRepository<OrderEntity, Long>{

}
