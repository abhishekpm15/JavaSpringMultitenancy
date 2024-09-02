package com.athreya.multi_tenancy.repository;

import com.athreya.multi_tenancy.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerModel, Integer> {
}
