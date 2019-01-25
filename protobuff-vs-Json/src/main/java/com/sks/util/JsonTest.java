package com.sks.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sks.model.Customer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class JsonTest {

    public static int jsonTest(Customer customer) {
        ObjectMapper objectMapper = new ObjectMapper();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectMapper.writeValue(byteArrayOutputStream, customer);
            byte[] data = byteArrayOutputStream.toByteArray();
            System.out.println("json data:::::" + byteArrayOutputStream);
            InputStream inputStream = new ByteArrayInputStream(data);
            objectMapper.readValue(inputStream, Customer.class);
            return data.length;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
