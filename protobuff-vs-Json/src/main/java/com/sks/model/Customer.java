package com.sks.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {
  @XmlElement(name = "fName")
  String fName;

  public String getfName() {
    return fName;
  }

  public void setfName(String fName) {
    this.fName = fName;
  }
}
