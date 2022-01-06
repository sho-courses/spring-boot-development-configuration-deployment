package org.nekosoft.pdffer;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@ConfigurationPropertiesScan(basePackages = "org.nekosoft.pdffer.props")
public class PdfferCoreConfiguration {

}
