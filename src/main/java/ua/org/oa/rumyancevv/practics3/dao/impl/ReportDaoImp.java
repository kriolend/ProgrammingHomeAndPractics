package ua.org.oa.rumyancevv.practics3.dao.impl;


import ua.org.oa.rumyancevv.practics3.Service.InMemoryDB;
import ua.org.oa.rumyancevv.practics3.dao.DAO;
import ua.org.oa.rumyancevv.practics3.model.Report;

/**
 * Created by user on 04.02.2016.
 */
public class ReportDaoImp implements DAO<Report> {
    @Override
    public long create(Report report) {
        int id = InMemoryDB.getInMemoryDB().getReports().create(report);
        if (id > 0) {
            InMemoryDB.getInMemoryDB().getReports().read(id).setId(id);
        }
        return id;
    }

    @Override
    public Report read(long index) {
        return InMemoryDB.getInMemoryDB().getReports().read((int)index);
    }

    @Override
    public Report update(long index, Report report) {
        return InMemoryDB.getInMemoryDB().getReports().update((int)index, report);
    }

    @Override
    public Report delete(long index) {
        return InMemoryDB.getInMemoryDB().getReports().delete((int)index);
    }

    @Override
    public int size() {
        return InMemoryDB.getInMemoryDB().getReports().getAll().length;
    }
}
