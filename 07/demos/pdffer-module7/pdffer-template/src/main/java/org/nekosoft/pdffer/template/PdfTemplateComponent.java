package org.nekosoft.pdffer.template;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A stereotype annotation to mark a class as a PDF template for the PDFfer registry. PDF templates must reside in
 * the {@link org.nekosoft.PDFferTemplates} package and must implement the {@link org.nekosoft.pdffer.template.PdfTemplate}
 * interface.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PdfTemplateComponent {

    /**
     * The name of this template in the registry.
     *
     * @return the string
     */
    String name();

    /**
     * Whether the template should be a singleton in the registry context. All templates by default are prototypes.
     *
     * @return <code>true</code> if the template should be created in the registry context as a singleton.
     */
    boolean singleton() default false;

}
