package com.study.seata;

import io.seata.spring.boot.autoconfigure.SeataAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SeataAutoConfiguration.class)
public class SeataConfig {
}