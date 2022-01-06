package org.nekosoft.pdffer;

import java.util.Map;

import org.nekosoft.pdffer.registry.PdfferRegistryBean;
import org.nekosoft.pdffer.template.PdfTemplate;
import org.springframework.stereotype.Component;

@Component
public class PdfferProducerBean {

    private final PdfferRegistryBean registry;

    public PdfferProducerBean(PdfferRegistryBean registry) {
        this.registry = registry;
    }

    public byte[] generatePdfDocument(String templateName, Map<String, Object> data) {
        PdfTemplate template = findTemplate(templateName);
        template.setPdfData(data);
        if (!template.validate()) {
            throw new IllegalArgumentException("PDF Template payload is not valid");
        }
        template.generate();
        return template.getPdfContent();
    }

    PdfTemplate findTemplate(String templateName) {
        return registry.findTemplate(templateName);
    }

}
