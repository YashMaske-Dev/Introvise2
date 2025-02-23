package com.interviewassistant.application.Services;


import com.interviewassistant.application.Models.PdfFile;
import com.interviewassistant.application.Repositories.PdfFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

//@Service
//public class PdfStorageService {
//
//    @Autowired
//    private PdfFileRepository pdfFileRepository;
//
//    @Value("${file.upload-dir}") // Define the upload directory in application.properties
//    private String uploadDir;
//
//    // Upload a PDF file and store its path in the database
//    public String uploadPdf(MultipartFile file) throws IOException {
//        // Ensure the upload directory exists
//        Path uploadPath = Paths.get(uploadDir);
//        if (!Files.exists(uploadPath)) {
//            Files.createDirectories(uploadPath);
//        }
//
//        // Generate a unique file name
//        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
//        Path filePath = uploadPath.resolve(fileName);
//
//        // Save the file to the local file system
//        Files.copy(file.getInputStream(), filePath);
//
//        // Save the file path in the database
//        PdfFile pdfFile = new PdfFile();
//        pdfFile.setFilePath(filePath.toString());
//        pdfFileRepository.save(pdfFile);
//
//        return "File uploaded successfully. Path: " + filePath;
//    }
//
//    // Download a PDF file by ID
//    public byte[] downloadPdf(Long id) throws IOException {
//        PdfFile pdfFile = pdfFileRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("File not found"));
//
//        Path filePath = Paths.get(pdfFile.getFilePath());
//        return Files.readAllBytes(filePath);
//    }

@Service
public class PdfStorageService {

    @Autowired
    private PdfFileRepository pdfFileRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public String uploadPdf(MultipartFile file, String jobTitle, String jobDescription, String requiredSkills) throws IOException {
        // Ensure the upload directory exists
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Generate a unique file name
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);

        // Save the file to the local file system
        Files.copy(file.getInputStream(), filePath);

        // Save the file path and job details in the database
        PdfFile pdfFile = new PdfFile();
        pdfFile.setFilePath(filePath.toString());
        pdfFile.setJobTitle(jobTitle);
        pdfFile.setJobDescription(jobDescription);
        pdfFile.setRequiredSkills(requiredSkills);
        pdfFileRepository.save(pdfFile);

        return "File uploaded successfully. Path: " + filePath;
    }
}