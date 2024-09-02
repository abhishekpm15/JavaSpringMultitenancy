package com.athreya.multi_tenancy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class DataSourceConfig {
    @Bean
    public DataSource dataSource(){
        System.out.println("Inside datasource");
        RoutingDataSource routingDataSource = new RoutingDataSource();
        Map<Object,Object> dataSources = new HashMap<>();
        dataSources.put("user1",createDataSource("jdbc:postgresql://localhost:5433/User1_db"));
        dataSources.put("user2",createDataSource("jdbc:postgresql://localhost:5433/User2_db"));
        routingDataSource.setTargetDataSources(dataSources);
        routingDataSource.setDefaultTargetDataSource(createDataSource("jdbc:postgresql://localhost:5433/DefaultDB"));
        routingDataSource.afterPropertiesSet();
        return routingDataSource;
    }

    private DataSource createDataSource(String url) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername("postgres");
        dataSource.setPassword("1029");
        return dataSource;
    }
}
