package com.sks.util;

import example.simple.CustomerOuterClass;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ProtoTest {
    public static int protoTest(CustomerOuterClass.Customer message) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            message.writeTo(byteArrayOutputStream);
      System.out.println("Proto  message:::::"+message);
            byte[] data = byteArrayOutputStream.toByteArray();
      //System.out.println("Serialized proto:::"+ data);
            InputStream inputStream = new ByteArrayInputStream(data);
      //System.out.println(inputStream);
            CustomerOuterClass.Customer.parseFrom(inputStream);
            return data.length;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
