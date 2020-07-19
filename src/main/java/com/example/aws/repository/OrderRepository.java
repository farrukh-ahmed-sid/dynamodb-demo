package com.example.aws.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.example.aws.entity.Order;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

  @Autowired private DynamoDBMapper mapper;

  public Order addOrder(Order order) {
    mapper.save(order);
    return order;
  }

  public Order findById(String id) {
    return mapper.load(Order.class, id);
  }

  public void deleteOrder(Order order) {
    mapper.delete(order);
  }

  public Order updateOrder(Order order) {

    DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
    Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
    expectedMap.put(
        "id", new ExpectedAttributeValue(new AttributeValue().withS(order.getId())));
    dynamoDBSaveExpression.setExpected(expectedMap);

    mapper.save(order, dynamoDBSaveExpression);
    return order;
  }
}
