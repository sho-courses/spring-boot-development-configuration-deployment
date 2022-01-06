package org.nekosoft.pdffer._misc;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
@ConditionalOnResource(resources = "customlog.config")
public class CustomLoggerConfiguration {

    @ConditionalOnBean(name = "loggerBean", type = "org.nk.CustomLoggingConfig")
    @Bean String loggerCustomBeanName() {
        return CustomLoggerConfiguration.class.getCanonicalName();
    }

    @ConditionalOnMissingBean(name = "loggerBean", type = "org.nk.CustomLoggingConfig")
    @Bean Logger loggerCustomBean() {
        return Logger.getLogger(CustomLoggerConfiguration.class.getCanonicalName());
    }

    @ConditionalOnClass(name = "org.nk.CoolClass")
    @Bean CoolBean coolBean() {
        return new CoolBean();
    }

}
