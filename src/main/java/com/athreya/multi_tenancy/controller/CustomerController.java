package com.athreya.multi_tenancy.controller;

import com.athreya.multi_tenancy.UserContext;
import com.athreya.multi_tenancy.model.CustomerModel;
import com.athreya.multi_tenancy.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers/{userID}")
    public List<CustomerModel> getCustomers(@PathVariable String userID){
        System.out.println("Getting customers" + userID);
        UserContext.setUser(userID);
        try{
            return customerService.getAllCustomers();
        }
        catch (Exception e){
            System.out.println("Exception " + e);
        }
        return null;
    }

    @GetMapping("/customers/{userID}/{customerID}")
    public CustomerModel getCustomerByID(@PathVariable String userID, @PathVariable int customerID){
        System.out.println("Getting customers" + userID);
        UserContext.setUser(userID);
        try{
            return customerService.getCustomerByID(customerID);
        }
        catch (Exception e){
            System.out.println("Exception " + e);
        }
        return null;
    }

    @PostMapping("/customers/{userID}")
    public boolean insertCustomer(@PathVariable String userID, @RequestBody CustomerModel customer){
        System.out.println("Getting customers" + userID);
        UserContext.setUser(userID);
        try{
            return customerService.insertCustomer(customer);
        }
        catch (Exception e){
            System.out.println("Exception " + e);
        }
        return false;
    }

    @DeleteMapping("/customers/{userID}/{customerID}")
    public boolean deleteCustomerByID(@PathVariable String userID, @PathVariable int customerID){
        System.out.println("Getting customers" + userID);
        UserContext.setUser(userID);
        try{
            return customerService.deleteCustomerByID(customerID);
        }
        catch (Exception e){
            System.out.println("Exception " + e);
        }
        return false;
    }
}
