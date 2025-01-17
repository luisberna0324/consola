package com.soltelec.consola.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Setter
@Getter
@Configuration
@PropertySource("classpath:application.yml")
@ConfigurationProperties("spring.datasource-mysql.hikari")
public class HikariMysqlProperties {

    private String poolName;

    private int minimumIdle;

    private int maximumPoolSize;

    private int idleTimeout;
}
