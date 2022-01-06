package org.nekosoft.pdffer.registry;

import org.nekosoft.pdffer.template.PdfTemplateComponent;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

/**
 * The type Pdffer template bean name generator.
 */
public class PdfferTemplateBeanNameGenerator implements BeanNameGenerator {
	
	@Override
	public String generateBeanName(BeanDefinition def, BeanDefinitionRegistry reg) {
		try {
			Class<?> c = Class.forName(def.getBeanClassName());
			PdfTemplateComponent annotation = c.getAnnotation(PdfTemplateComponent.class);
			return annotation.name();
		} catch (ClassNotFoundException e) {
			// this should never happen, given the scanner filters in place...
			throw new BeanCreationException("Cannot find bean class");
		}
	}
	
}