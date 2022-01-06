package org.nekosoft.pdffer.registry;

import org.nekosoft.pdffer.template.PdfTemplateComponent;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ScopeMetadata;
import org.springframework.context.annotation.ScopeMetadataResolver;

/**
 * The type Pdffer template scope metadata resolver.
 */
public class PdfferTemplateScopeMetadataResolver implements ScopeMetadataResolver {
	@Override
	public ScopeMetadata resolveScopeMetadata(BeanDefinition definition) {
		try {
			Class<?> c = Class.forName(definition.getBeanClassName());
			PdfTemplateComponent annotation = c.getAnnotation(PdfTemplateComponent.class);
			ScopeMetadata scope = new ScopeMetadata();
			if (annotation.singleton()) {
				scope.setScopeName(BeanDefinition.SCOPE_SINGLETON);
			} else {
				scope.setScopeName(BeanDefinition.SCOPE_PROTOTYPE);
			}
			return scope;
		} catch (ClassNotFoundException e) { // this should never happen
			throw new BeanCreationException("Cannot find bean class");
		}
	}
}