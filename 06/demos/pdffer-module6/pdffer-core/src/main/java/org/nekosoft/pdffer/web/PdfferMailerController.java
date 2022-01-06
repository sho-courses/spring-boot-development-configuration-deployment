package org.nekosoft.pdffer.web;

import org.nekosoft.pdffer.PdfferProducerBean;
import org.nekosoft.pdffer.mail.PdfferMailerBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletResponse;

@RestController
@ConditionalOnWebApplication
@ConditionalOnClass(name = "javax.mail.internet.InternetAddress")
@ConditionalOnBean(type = {"org.nekosoft.pdffer.mail.PdfferMailerBean", "org.nekosoft.pdffer.PdfferProducerBean"})
@ConditionalOnProperty(name = "pdffer.skip.mailer.controller", havingValue = "false", matchIfMissing = true)
@RequestMapping("${pdffer.mailer.controller.base_uri:${pdffer.web.controller.base_uri:pdffer}}")
public class PdfferMailerController {

    static Logger logger = LoggerFactory.getLogger(PdfferMailerController.class);

    private final PdfferMailerBean pdfferMailer;
    private final PdfferProducerBean pdfferProducer;

    public PdfferMailerController(PdfferProducerBean pdfferProducer, PdfferMailerBean pdfferMailer) {
        this.pdfferProducer = pdfferProducer;
        this.pdfferMailer = pdfferMailer;
    }

    @PostMapping("${pdffer.web.controller.email_uri:mail}/{templateId}")
    public void email(@PathVariable String templateId, @RequestBody EmailRequestData requestData, HttpServletResponse response) {
        try {
            byte[] pdfBytes = pdfferProducer.generatePdfDocument(templateId, requestData.getPayload());
            pdfferMailer.sendMessageWithPdfAttachmentToList(requestData.getEmailTo(), requestData.getSubject(), requestData.getMessage(), pdfBytes, requestData.getFilename(), requestData.getSendFrom(), requestData.getReplyTo());
        } catch (IllegalArgumentException e) {
            if (e.getCause() instanceof MessagingException) {
                logger.error("Internal Server Error", e);
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } else {
                logger.debug("Bad Request", e);
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        }
    }
}
