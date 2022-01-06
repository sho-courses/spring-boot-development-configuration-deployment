package org.nekosoft.pdffer._misc;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(name = "org.nk.CoolClass")
public class CoolClassLoggerConfiguration {

    @Bean
    CoolClass coolClass() {
        return new CoolClass();
    }

}
