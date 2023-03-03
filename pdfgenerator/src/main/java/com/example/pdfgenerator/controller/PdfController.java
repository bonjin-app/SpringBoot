package com.example.pdfgenerator.controller;

import com.example.pdfgenerator.service.PdfService;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Controller
public class PdfController {

    private final PdfService pdfService;

    public PdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/pdf")
    public String pdfPage() {
        return "pdf";
    }

    @PostMapping("/generatePdfFile")
    public void generatePdfFile(HttpServletResponse response, String contentToGenerate) throws IOException {
        ByteArrayInputStream byteArrayInputStream = pdfService.convertHtmlToPdf(contentToGenerate);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=file.pdf");
        IOUtils.copy(byteArrayInputStream, response.getOutputStream());
    }
}
