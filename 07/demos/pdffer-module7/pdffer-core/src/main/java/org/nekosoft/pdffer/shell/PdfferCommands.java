package org.nekosoft.pdffer.shell;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.nekosoft.pdffer.PdfferProducerBean;
import org.nekosoft.pdffer.registry.PdfferRegistryBean;
import org.nekosoft.pdffer.template.PdfTemplate;
import org.nekosoft.pdffer.template.PdfTemplateComponent;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Profile;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * The type Pdffer commands.
 */
@ShellComponent
@ConditionalOnClass(
    name = "org.springframework.shell.standard.ShellComponent"
)
@Profile("pdffer-shell")
public class PdfferCommands {

    private final PdfferRegistryBean registry;
    private final PdfferProducerBean producer;
    private final ObjectMapper mapper;

    /**
     * Instantiates a new Pdffer commands.
     *
     * @param registry the registry
     * @param producer the producer
     */
    public PdfferCommands(PdfferRegistryBean registry, PdfferProducerBean producer) {
        this.registry = registry;
        this.producer = producer;
        this.mapper = new ObjectMapper();
    }

    /**
     * Templates list.
     *
     * @return the list
     */
    @ShellMethod("returns a list of all templates known to this instance")
    public List<String> templates() {
        return registry.listTemplates();
    }

    /**
     * Template list.
     *
     * @param name the name
     * @return the list
     */
    @ShellMethod("returns information about a specific template")
    public List<String> template(String name) {
        PdfTemplate template = registry.findTemplate(name);
        List<String> info = List.of(
                String.format("Template Name: %s", name),
                String.format("Template Class: %s", template.getClass().getName()),
                String.format("Is Singleton? %b", template.getClass().getAnnotation(PdfTemplateComponent.class).singleton())
        );
        return info;
    }

    /**
     * Generate.
     *
     * @param template the template
     * @param input    the input
     * @param output   the output
     * @return A confirmation message that the PDF was generated
     * @throws IOException the io exception
     */
    @ShellMethod("creates a PDF file from a template and JSON file, then stores it on disk")
    public String generate(String template, String input, String output) throws IOException {
        File inputFile = new File(input);
        Map<String, Object> data = mapper.readValue(inputFile, Map.class);
        byte[] pdf = producer.generatePdfDocument(template, data);
        try (FileOutputStream os = new FileOutputStream(output)) {
            os.write(pdf);
        }
        return String.format("Generated PDF for %s in %s", input, output);
    }

}
