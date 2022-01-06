package org.nekosoft.pdffer.registry;

import org.nekosoft.pdffer.template.PdfTemplate;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
 * The type Pdffer template exclude filter.
 */
public class PdfferTemplateExcludeFilter implements TypeFilter {

	@Override
	public boolean match(MetadataReader reader, MetadataReaderFactory factory) {
		try {
			Class<?> c = Class.forName(reader.getClassMetadata().getClassName());
			return !PdfTemplate.class.isAssignableFrom(c);
		} catch (ClassNotFoundException e) {
			return false;
		}
	}
	
}
