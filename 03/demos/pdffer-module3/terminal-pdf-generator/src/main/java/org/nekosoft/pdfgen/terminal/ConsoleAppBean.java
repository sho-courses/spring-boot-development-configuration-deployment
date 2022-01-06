package org.nekosoft.pdfgen.terminal;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.nekosoft.pdffer.PdfferProducerBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ConsoleAppBean implements CommandLineRunner {

    @Autowired
    private PdfferProducerBean pdffer;
    
    @Autowired
    ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Federico");
        map.put("surname", "Mestrone");
        map.put("age", 48);
        map.put("city", "London");
        byte[] output = pdffer.generatePdfDocument("default", map);
        try (FileOutputStream os = new FileOutputStream("output/default.pdf")) {
        	os.write(output);
        }
        System.out.println(context.getBean("default"));
    }
}
