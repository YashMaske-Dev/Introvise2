package com.interviewassistant.application.Models;

import jakarta.persistence.*;
import lombok.Data;

//@Entity
//@Data
//@Table (name="Resume_Details")
//public class PdfFile {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String filePath; // Stores the local file path
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFilePath() {
//        return filePath;
//    }
//
//    public void setFilePath(String filePath) {
//        this.filePath = filePath;
//    }
//}

@Entity
@Data
@Table (name="Resume_Details")
public class PdfFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filePath; // Stores the local file path
    private String jobTitle; // Stores the job title
    private String jobDescription; // Stores the job description
    private String requiredSkills; // Stores the required skills

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }
}