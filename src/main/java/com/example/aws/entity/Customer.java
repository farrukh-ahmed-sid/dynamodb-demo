package com.example.aws.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@DynamoDBDocument
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {

  @DynamoDBAttribute
  private String id;
  @DynamoDBAttribute
  private String name;

}
