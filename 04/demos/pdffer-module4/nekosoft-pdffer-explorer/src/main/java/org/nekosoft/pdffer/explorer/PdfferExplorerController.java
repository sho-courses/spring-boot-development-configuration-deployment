package org.nekosoft.pdffer.explorer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.nekosoft.pdffer.PdfferProducerBean;
import org.nekosoft.pdffer.registry.PdfferRegistryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.http.MediaType.*;

@Controller
@RequestMapping("explorer")
public class PdfferExplorerController {

    // The template resource for the /download page
    @Value("classpath:org/nekosoft/pdffer/explorer/download.html")
    private Resource downloadHtmlTemplate;

    // The template resource for the /email page
    @Value("classpath:org/nekosoft/pdffer/explorer/email.html")
    private Resource emailHtmlTemplate;

    private ObjectMapper mapper;
    private PdfferProducerBean pdffer;
    private PdfferRegistryBean registry;

    public PdfferExplorerController(ObjectMapper mapper, PdfferProducerBean pdffer, PdfferRegistryBean registry) {
        this.mapper = mapper;
        this.pdffer = pdffer;
        this.registry = registry;
    }

    /*
     * Takes a Resource object that represents an HTML template and returns a String with the HTML
     * content and any placeholder properly resolved to the corresponding values.
     * No placeholders are available in this module
     */
    private String htmlTemplateAsString(Resource resource, String result) {
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            String htmlTemplate = FileCopyUtils.copyToString(reader);
            StringBuilder pdfTemplateHtml = new StringBuilder();
            List<String> templatePaths = registry.listTemplates();
            for (String path : templatePaths) {
                pdfTemplateHtml.append("<option>");
                pdfTemplateHtml.append(path);
                pdfTemplateHtml.append("</option>\n");
            }
            return htmlTemplate
                    .replace("{{result}}", result)
                    .replace("{{templates}}", pdfTemplateHtml);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * Controller method mapped to GET /download by default
     * @return the HTML content for the download form
     */
    @GetMapping(value = "download", produces = TEXT_HTML_VALUE)
    @ResponseBody
    public String downloadForm() {
        return htmlTemplateAsString(downloadHtmlTemplate, "");
     }

    /**
     * Controller method mapped to POST /download by default
     * @param template the "pdfTemplate" HTML form field with the name of the template to apply
     *                 (only "default" available in this module)
     * @param payload the JSON text of the data for the PDF template
     * @return the bytes of the PDF file that was generated by the framework
     * @throws JsonProcessingException if the payload is not valid JSON text
     */
    @PostMapping(value = "download", produces = APPLICATION_PDF_VALUE)
    @ResponseBody
    public byte[] processDownloadForm(@RequestParam("pdfTemplate") String template, @RequestParam("pdfPayload") String payload) throws JsonProcessingException {
        Map<String,Object> pdfData = mapper.readValue(payload, ((Class<Map<String, Object>>)(Class<?>)Map.class));
        return pdffer.generatePdfDocument(template, pdfData);
     }

}
