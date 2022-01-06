package org.nekosoft.pdfgen.terminal;

import org.nekosoft.PDFferTemplates.DefaultPdfTemplate;
import org.nekosoft.pdffer.PdfferProducerBean;
import org.nekosoft.pdffer.registry.PdfferRegistryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

//@Component
public class HierarchicalContextBean implements CommandLineRunner {

    @Autowired
    AnnotationConfigApplicationContext context;

    @Autowired
    PdfferRegistryBean registry;

    @Override
    public void run(String... args) throws Exception {
        context.registerBean("myTemplate", DefaultPdfTemplate.class);

        System.out.print("PDF Template in main Context: ");
        System.out.println(context.getBean("myTemplate"));

        System.out.print("PDF Template in our Registry: ");
        System.out.println(registry.findTemplate("myTemplate"));
    }

}
