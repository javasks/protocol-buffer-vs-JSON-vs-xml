package com.sks.util;

import com.sks.model.Customer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class XmlTest {
    public static int xmlTest(Customer customer) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            marshaller.marshal(customer, byteArrayOutputStream);
            System.out.println("xml data::::::"+byteArrayOutputStream);
            byte[] data = byteArrayOutputStream.toByteArray();
      //System.out.println(data);
            InputStream inputStream = new ByteArrayInputStream(data);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            unmarshaller.unmarshal(inputStream);
            return data.length;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
