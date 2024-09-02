package com.athreya.multi_tenancy;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class RoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("Looking Up");
        return UserContext.getUser();
    }
}
