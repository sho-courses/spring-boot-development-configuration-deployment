package org.nekosoft.pdffer.explorer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

/**
 * The main class for the nekosoft-pdffer-explorer application.
 *
 * This only loads the PDFCoreConfiguration class through autoconfiguration.
 * The rest is all in the hands of the PDFfer library!
 *
 */
@SpringBootApplication
public class PdfferApp {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(PdfferApp.class);

//        application.setAdditionalProfiles("pdffer-explorer", "pdffer-shell");

//        Properties defProps = new Properties();
//        defProps.put("spring.profiles.group.pdffer-full", "pdffer-shell,pdffer-explorer");
//        application.setDefaultProperties(defProps);

        application.run(args);
    }

}
