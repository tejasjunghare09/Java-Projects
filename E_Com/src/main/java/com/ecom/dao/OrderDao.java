package com.ecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.pojos.Order;

public interface OrderDao extends JpaRepository<Order, Long> {

}
