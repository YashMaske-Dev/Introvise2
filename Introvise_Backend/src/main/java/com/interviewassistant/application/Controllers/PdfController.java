package com.interviewassistant.application.Controllers;


import com.interviewassistant.application.Services.PdfStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

//@RestController
//@RequestMapping("/api/pdf")
//public class PdfController {
//
//    @Autowired
//    private PdfStorageService pdfStorageService;
//
//    // Upload a PDF file
//    @PostMapping("/upload")
//    public String uploadPdf(@RequestParam("file") MultipartFile file) throws IOException {
//        return pdfStorageService.uploadPdf(file);
//    }
//
//    // Download a PDF file by ID
//    @GetMapping("/download/{id}")
//    public ResponseEntity<byte[]> downloadPdf(@PathVariable Long id) throws IOException {
//        byte[] fileContent = pdfStorageService.downloadPdf(id);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_PDF);
//        headers.setContentDispositionFormData("attachment", "file.pdf");
//
//        return ResponseEntity.ok()
//                .headers(headers)
//                .body(fileContent);
//    }
//}
@RestController
@RequestMapping("/api/pdf")
@CrossOrigin(origins = "http://localhost:5173")
public class PdfController {

    @Autowired
    private PdfStorageService pdfStorageService;

    @PostMapping("/upload")
    public String uploadPdf(@RequestParam("file") MultipartFile file,
                            @RequestParam("jobTitle") String jobTitle,
                            @RequestParam("jobDescription") String jobDescription,
                            @RequestParam("requiredSkills") String requiredSkills) throws IOException {
        return pdfStorageService.uploadPdf(file, jobTitle, jobDescription, requiredSkills);
    }
}