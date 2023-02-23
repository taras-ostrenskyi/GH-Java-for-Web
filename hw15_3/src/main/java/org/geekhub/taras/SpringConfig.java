package org.geekhub.taras;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.geekhub.taras")
@PropertySource("classpath:car.properties")
public class SpringConfig {

}
