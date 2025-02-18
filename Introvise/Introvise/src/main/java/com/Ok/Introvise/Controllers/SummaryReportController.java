package com.Ok.Introvise.Controllers;



import com.Ok.Introvise.Models.SummaryReport;
import com.Ok.Introvise.Services.SummaryReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/summary")
public class SummaryReportController {

    @Autowired
    private SummaryReportService summaryReportService;

    @PostMapping("/reports")
    public SummaryReport createSummaryReport(@RequestBody SummaryReport summaryReport) {
        return summaryReportService.saveSummaryReport(summaryReport);
    }

    @GetMapping("/reports/{id}")
    public SummaryReport getSummaryReport(@PathVariable Long id) {
        return summaryReportService.getSummaryReportById(id);
    }
}