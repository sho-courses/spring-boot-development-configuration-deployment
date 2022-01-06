package org.nekosoft.pdffer.registry;

import java.util.List;

import org.nekosoft.pdffer.template.PdfTemplate;
import org.nekosoft.pdffer.template.PdfTemplateComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * The type Pdffer registry bean.
 */
@Component
public class PdfferRegistryBean {

    /**
     * The Logger.
     */
    private static Logger logger = LoggerFactory.getLogger(PdfferRegistryBean.class);

    private final ApplicationContext context;

    /**
     * Instantiates a new Pdffer registry bean.
     *
     * @param parentContext the parent context
     */
    public PdfferRegistryBean(ApplicationContext parentContext) {
        logger.debug("Creating separate template context under [{}]", parentContext.getId());
        AnnotationConfigApplicationContext childContext = new AnnotationConfigApplicationContext();
        childContext.setId("pdffer-templates");
        childContext.register(PdfferTemplateRegistryConfiguration.class);
        childContext.refresh();
        childContext.start();
        context = childContext;
        logger.debug("Created separate template context [{}] under [{}]", context.getId(), parentContext.getId());
    }

    /**
     * Find template pdf template.
     *
     * @param templateName the template name
     * @return the pdf template
     */
    public PdfTemplate findTemplate(String templateName) {
        logger.debug("Looking for PDF template '{}' in [{}]", templateName, context.getId());
        return context.getBean(templateName, PdfTemplate.class);
    }

    /**
     * List templates list.
     *
     * @return the list
     */
    public List<String> listTemplates() {
        logger.debug("Listing all available PDF templates in [{}]", context.getId());
        return List.of(context.getBeanNamesForAnnotation(PdfTemplateComponent.class));
    }

}
