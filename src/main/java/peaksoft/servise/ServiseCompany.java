package peaksoft.servise;

import peaksoft.Entity.Company;

import java.util.List;

public interface ServiseCompany {

    void save(Company company);

    void Update(Company company);

    //delete by id
    void deleteById(long id);

    //get by id
    Company getById(long id);

    //delete all
    void deleteAll();

    //get all users
    List<Company> getAllCompany();
}
