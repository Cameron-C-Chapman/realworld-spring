package org.realworld.webservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ConduitServiceApplicationConfig {

    @Autowired
    DataSource dataSource;


}
