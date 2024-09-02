package com.athreya.multi_tenancy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CustomerModel {

    @Id
    int customerID;
    String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
}
