package org.nekosoft.pdffer.registry;

import org.nekosoft.pdffer.template.PdfTemplateComponent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
		basePackages = "org.nekosoft.PDFferTemplates",
		useDefaultFilters = false,
		excludeFilters = @ComponentScan.Filter(
				type = FilterType.CUSTOM, value = PdfferTemplateExcludeFilter.class
		),
		includeFilters = @ComponentScan.Filter(
				type = FilterType.ANNOTATION, value = PdfTemplateComponent.class
		),
		nameGenerator = PdfferTemplateBeanNameGenerator.class,
		scopeResolver = PdfferTemplateScopeMetadataResolver.class
)
public class PdfferTemplateRegistryConfiguration {

}
