package com.example.aws.controller;

import com.example.aws.entity.Order;
import com.example.aws.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  @Autowired private OrderRepository orderRepository;

  @PostMapping("/order")
  @ResponseStatus(HttpStatus.OK)
  public Order saveOrder(@RequestBody Order order) {
    return orderRepository.addOrder(order);
  }

  @GetMapping("/order/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Order findById(@PathVariable String id) {
    return orderRepository.findById(id);
  }

  @DeleteMapping("/order")
  @ResponseStatus(HttpStatus.CREATED)
  public void deleteOrder(@RequestBody Order order) {
    orderRepository.deleteOrder(order);
  }

  @PutMapping("/order")
  @ResponseStatus(HttpStatus.OK)
  public Order updateOrder(@RequestBody Order order) {
    return orderRepository.updateOrder(order);
  }
}
