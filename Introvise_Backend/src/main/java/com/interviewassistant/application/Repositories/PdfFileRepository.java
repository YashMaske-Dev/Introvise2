package com.interviewassistant.application.Repositories;


import com.interviewassistant.application.Models.PdfFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PdfFileRepository extends JpaRepository<PdfFile, Long> {
}