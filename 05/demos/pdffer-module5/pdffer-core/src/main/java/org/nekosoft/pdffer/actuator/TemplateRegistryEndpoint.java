package org.nekosoft.pdffer.actuator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nekosoft.pdffer.registry.PdfferRegistryBean;
import org.nekosoft.pdffer.template.PdfTemplate;
import org.nekosoft.pdffer.template.PdfTemplateComponent;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="pdfferTemplateRegistry")
@ConditionalOnClass(name = "org.springframework.boot.actuate.endpoint.annotation.Endpoint")
@Profile("!pdffer-no-actuator & !pdffer-shell")
public class TemplateRegistryEndpoint {
	
	private PdfferRegistryBean registry;

	public TemplateRegistryEndpoint(PdfferRegistryBean registry) {
		this.registry = registry;
	}
	
	@ReadOperation
    public List<String> allTemplates() {
        return registry.listTemplates();
    }
	
	@ReadOperation
    public Map<String, Object> template(@Selector String name) {
		PdfTemplate template = registry.findTemplate(name);
		Map<String, Object> data = new HashMap<>();
		data.put("className", template.getClass().getName());
		data.put("templateName", name);
		data.put("singleton", template.getClass().getAnnotation(PdfTemplateComponent.class).singleton());
        return data;
    }
	
}
