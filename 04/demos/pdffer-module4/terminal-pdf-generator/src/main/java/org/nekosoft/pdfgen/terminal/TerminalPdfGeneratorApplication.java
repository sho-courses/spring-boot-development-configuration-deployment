package org.nekosoft.pdfgen.terminal;

import org.nekosoft.pdffer.template.PdfTemplateComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(useDefaultFilters = true, includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = PdfTemplateComponent.class)})
public class TerminalPdfGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(TerminalPdfGeneratorApplication.class, args);
	}

}
