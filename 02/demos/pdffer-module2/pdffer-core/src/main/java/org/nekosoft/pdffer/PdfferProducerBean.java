package org.nekosoft.pdffer;

import java.util.Map;

import org.nekosoft.PDFferTemplates.DefaultPdfTemplate;
import org.nekosoft.pdffer.template.PdfTemplate;
import org.springframework.stereotype.Component;

@Component
public class PdfferProducerBean {

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
        return new DefaultPdfTemplate();
    }

}
