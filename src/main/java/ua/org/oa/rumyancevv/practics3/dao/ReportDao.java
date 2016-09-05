package ua.org.oa.rumyancevv.practics3.dao;

import ua.org.oa.rumyancevv.practics3.model.Report;

import java.util.List;

/**
 * Created by user on 02.02.2016.
 */
public interface ReportDao {
    long createReport(Report user);
    Report readReportUser(long id);
    List<Report> readAll();
    boolean updateReport(Report user);
    boolean deleteReport(long id);
}
