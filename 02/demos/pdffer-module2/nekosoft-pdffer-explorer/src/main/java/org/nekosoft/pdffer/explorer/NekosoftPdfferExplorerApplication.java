package org.nekosoft.pdffer.explorer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * The main class for the nekosoft-pdffer-explorer application.
 * This configuration only exposes one controller bean with mappings for GET /download and POST /download
 */
@SpringBootApplication
public class NekosoftPdfferExplorerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NekosoftPdfferExplorerApplication.class, args);
    }

}
