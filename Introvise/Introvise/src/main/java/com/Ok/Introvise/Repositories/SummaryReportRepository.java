package com.Ok.Introvise.Repositories;



import com.Ok.Introvise.Models.SummaryReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummaryReportRepository extends JpaRepository<SummaryReport, Long> {
}