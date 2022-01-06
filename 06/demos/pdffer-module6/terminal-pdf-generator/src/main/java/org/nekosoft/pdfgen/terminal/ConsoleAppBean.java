package org.nekosoft.pdfgen.terminal;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.nekosoft.pdffer.PdfferProducerBean;
import org.nekosoft.pdffer.props.PdfferWebControllerProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ConsoleAppBean implements CommandLineRunner {

    @Autowired
    private PdfferProducerBean pdffer;
    
    @Autowired
    Environment env;

    @Autowired
    PdfferWebControllerProps webProps;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Base URI for this instance of PDFfer: ");
        System.out.println(env.getProperty("pdffer.web.controller.base-uri"));
        System.out.println("Full URL for Save endpoint: ");
        System.out.println(env.resolvePlaceholders("http://localhost:8080/${pdffer.web.controller.base-uri}/${pdffer.web.controller.save-uri}"));

        System.out.println("Base URI for this instance of PDFfer: ");
        System.out.println(webProps.getBaseUri());
        System.out.println("Full URL for Save endpoint: ");
        System.out.printf("http://localhost:8080/%s/%s%n", webProps.getBaseUri(), webProps.getSaveUri());

        Map<String, Object> map = new HashMap<>();
        map.put("name", "Federico");
        map.put("surname", "Mestrone");
        map.put("age", 48);
        map.put("city", "London");
        byte[] output = pdffer.generatePdfDocument("default", map);
        try (FileOutputStream os = new FileOutputStream("output/default.pdf")) {
        	os.write(output);
        }

    }
}
