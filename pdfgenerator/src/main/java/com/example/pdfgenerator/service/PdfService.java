package com.example.pdfgenerator.service;

import java.io.ByteArrayInputStream;

public interface PdfService {
    ByteArrayInputStream convertHtmlToPdf(String htmlContent);
}
