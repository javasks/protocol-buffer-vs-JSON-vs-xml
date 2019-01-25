package com.sks.java;

import com.sks.model.Customer;
import com.sks.util.JsonTest;
import com.sks.util.ProtoTest;
import com.sks.util.XmlTest;
import example.simple.CustomerOuterClass;

public class PerformanceComparision {

  public static void main(String[] args) {
    CustomerOuterClass.Customer.Builder builder = CustomerOuterClass.Customer.newBuilder();
    CustomerOuterClass.Customer message = builder.setFName("sandeep").build();
    long startTime;
    long endTime;
    int iteration = 10;
    int i;
    int size = 0;
    startTime = System.currentTimeMillis();
    for (i = 0; i < iteration; i++) {
      size=ProtoTest.protoTest(message);
    }
    endTime = System.currentTimeMillis();
    //System.out.println("==============================================================================");
    System.out.println("Time taken by proto buffer serialization and deserialization in ms:::" + Long.toString(endTime - startTime));
    System.out.println("protobuffer Size:::::" + Integer.toString(size));
    System.out.println("==============================================================================");

    Customer customer = new Customer();
    customer.setfName("sandeep");

    startTime = System.currentTimeMillis();
    for (i = 0; i < iteration; i++) {
      size=XmlTest.xmlTest(customer);
    }
    endTime = System.currentTimeMillis();
    System.out.println("Time taken by xml serialization and deserialization in ms:::" + Long.toString(endTime - startTime));
    System.out.println("XML Size::::::::::::" + Integer.toString(size));
    System.out.println("==============================================================================");

    startTime = System.currentTimeMillis();
    for (i = 0; i < iteration; i++) {
      size=JsonTest.jsonTest(customer);
    }
    endTime = System.currentTimeMillis();
    System.out.println("Time taken by json serialization and deserialization in ms:::" + Long.toString(endTime - startTime));
    System.out.println("JSON Size::::::::::::" + Integer.toString(size));
    System.out.println("==============================================================================");
  }
}
