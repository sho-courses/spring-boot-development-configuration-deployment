package org.nekosoft.pdffer;

import java.util.Map;

import org.nekosoft.pdffer.registry.PdfferRegistryBean;
import org.nekosoft.pdffer.template.PdfTemplate;
import org.springframework.stereotype.Component;

/**
 * The type Pdffer producer bean.
 */
@Component
public class PdfferProducerBean {

    private final PdfferRegistryBean registry;

    /**
     * Instantiates a new Pdffer producer bean.
     *
     * @param registry the registry
     */
    public PdfferProducerBean(PdfferRegistryBean registry) {
        this.registry = registry;
    }

    /**
     * Generate pdf document byte [ ].
     *
     * @param templateName the template name
     * @param data         the data
     * @return the byte [ ]
     */
    public byte[] generatePdfDocument(String templateName, Map<String, Object> data) {
        PdfTemplate template = findTemplate(templateName);
        template.setPdfData(data);
        if (!template.validate()) {
            throw new IllegalArgumentException("PDF Template payload is not valid");
        }
        template.generate();
        return template.getPdfContent();
    }

    /**
     * Find template pdf template.
     *
     * @param templateName the template name
     * @return the pdf template
     */
    PdfTemplate findTemplate(String templateName) {
        return registry.findTemplate(templateName);
    }

}
