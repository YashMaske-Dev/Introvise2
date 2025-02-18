package com.Ok.Introvise.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "summary_reports")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SummaryReport {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "overall_confidence_level")
    private String overallConfidenceLevel;

    @Column(name = "nervousness_score")
    private String nervousnessScore;

    @Column(name = "engagement_level")
    private String engagementLevel;

    @Column(name = "disinterest_indicators")
    private String disinterestIndicators;

    @Column(name = "most_frequent_emotion")
    private String mostFrequentEmotion;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOverallConfidenceLevel() {
        return overallConfidenceLevel;
    }

    public void setOverallConfidenceLevel(String overallConfidenceLevel) {
        this.overallConfidenceLevel = overallConfidenceLevel;
    }

    public String getNervousnessScore() {
        return nervousnessScore;
    }

    public void setNervousnessScore(String nervousnessScore) {
        this.nervousnessScore = nervousnessScore;
    }

    public String getEngagementLevel() {
        return engagementLevel;
    }

    public void setEngagementLevel(String engagementLevel) {
        this.engagementLevel = engagementLevel;
    }

    public String getDisinterestIndicators() {
        return disinterestIndicators;
    }

    public void setDisinterestIndicators(String disinterestIndicators) {
        this.disinterestIndicators = disinterestIndicators;
    }

    public String getMostFrequentEmotion() {
        return mostFrequentEmotion;
    }

    public void setMostFrequentEmotion(String mostFrequentEmotion) {
        this.mostFrequentEmotion = mostFrequentEmotion;
    }
}