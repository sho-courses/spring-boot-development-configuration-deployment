package org.nekosoft.pdffer.template;

import java.util.Map;

/**
 * This interface is implemented by classes that want to be added to the PDFfer registry as PDF templates.
 * PDF template classes must also be annotated with the {@link PdfTemplateComponent} stereotype, which allows
 * developers to provide the {@link PdfTemplateComponent#name() name} of the template and to indicate whether the
 * template should be configured as a {@link PdfTemplateComponent#singleton() singleton} in the registry context.
 *
 * The lifecycle of a template is meant to be as follows
 * - created as a Spring bean in the PDFfer Registry context when needed to generate a PDF document
 * - the PDF payload is set with the {@link #setPdfData(Map)} method
 * - the payload is validated with the {@link #validate()} method
 * - the {@link #generate()} method is called to process the payload and create the actual PDF document
 * - the bytes of the PDF are retrieved with the {@link #getPdfContent()} method by the requester
 */
public interface PdfTemplate {
    /**
     * Gets pdf data.
     *
     * @return the pdf data
     */
    Map<String, Object> getPdfData();

    /**
     * Sets pdf data.
     *
     * @param data the data
     */
    void setPdfData(Map<String, Object> data);

    /**
     * Validate boolean.
     *
     * @return the boolean
     */
    boolean validate();

    /**
     * Generate.
     */
    void generate();

    /**
     * Get pdf content byte [ ].
     *
     * @return the byte [ ]
     */
    byte[] getPdfContent();
}
