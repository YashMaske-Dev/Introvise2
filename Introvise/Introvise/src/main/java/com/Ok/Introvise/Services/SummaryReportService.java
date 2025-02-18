package com.Ok.Introvise.Services;


import com.Ok.Introvise.Models.SummaryReport;
import com.Ok.Introvise.Repositories.SummaryReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummaryReportService {

    @Autowired
    private SummaryReportRepository summaryReportRepository;

    public SummaryReport saveSummaryReport(SummaryReport summaryReport) {
        return summaryReportRepository.save(summaryReport);
    }

    public SummaryReport getSummaryReportById(Long id) {
        return summaryReportRepository.findById(id).orElse(null);
    }
}