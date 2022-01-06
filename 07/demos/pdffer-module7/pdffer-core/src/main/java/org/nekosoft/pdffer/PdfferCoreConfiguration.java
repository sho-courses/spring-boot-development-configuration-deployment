package org.nekosoft.pdffer;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * The type Pdffer core configuration.
 */
@Configuration
@ComponentScan
@ConfigurationPropertiesScan(basePackages = "org.nekosoft.pdffer.props")
public class PdfferCoreConfiguration {

}
