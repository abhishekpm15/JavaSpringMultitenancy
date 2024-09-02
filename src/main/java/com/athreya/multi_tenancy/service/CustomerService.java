package com.athreya.multi_tenancy.service;

import com.athreya.multi_tenancy.model.CustomerModel;
import com.athreya.multi_tenancy.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public List<CustomerModel> getAllCustomers(){
        return customerRepo.findAll();
    }

    public CustomerModel getCustomerByID(int customerID){
        return customerRepo.findById(customerID).orElse(null);
    }

    public boolean insertCustomer(CustomerModel customer){
        try {
            customerRepo.save(customer);
            return true;
        }
        catch (Exception e){
            System.out.println("Could not insert");
            return false;
        }
    }

    public boolean deleteCustomerByID(int customerID){
        try{
            customerRepo.deleteById(customerID);
            return true;
        }
        catch (Exception e){
            System.out.println("Could not delete");
        }
        return false;
    }
}
