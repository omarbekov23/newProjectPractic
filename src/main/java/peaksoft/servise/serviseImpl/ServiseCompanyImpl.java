package peaksoft.servise.serviseImpl;

import peaksoft.Entity.Company;
import peaksoft.dao.DaoCompany;
import peaksoft.servise.ServiseCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiseCompanyImpl implements ServiseCompany {

    private DaoCompany daoCompany;

    @Autowired
    public ServiseCompanyImpl(DaoCompany daoCompany) {
        this.daoCompany = daoCompany;
    }


    @Override
    public void save(Company company) {
        daoCompany.save(company);
    }

    @Override
    public void Update(Company company) {
        daoCompany.Update(company);
    }

    @Override
    public void deleteById(long id) {
        daoCompany.deleteById(id);
    }

    @Override
    public Company getById(long id) {
        return daoCompany.getById(id);
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Company> getAllCompany() {
        return daoCompany.getAllCompany();
    }
}
