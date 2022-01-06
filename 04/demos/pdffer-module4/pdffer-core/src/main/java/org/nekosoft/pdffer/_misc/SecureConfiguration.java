package org.nekosoft.pdffer._misc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@Conditional(SecurityTokenCondition.class)
public class SecureConfiguration {
}
