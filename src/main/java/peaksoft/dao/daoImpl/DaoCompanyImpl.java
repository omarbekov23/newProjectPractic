package peaksoft.dao.daoImpl;

import peaksoft.Entity.Company;
import peaksoft.dao.DaoCompany;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
public class DaoCompanyImpl implements DaoCompany {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Company company) {
        entityManager.persist(company);
    }

    @Override
    @Transactional
    public void Update(Company company) {
        entityManager.merge(company);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        entityManager.remove(entityManager.find(Company.class,id));
    }

    @Override
    @Transactional
    public Company getById(long id) {
        return entityManager.find(Company.class,id);
    }

    @Override
    @Transactional
    public void deleteAll() {
    }

    @Override
    @Transactional
    public List<Company> getAllCompany() {
        List<Company> companies = entityManager.createQuery("from Company ", Company.class).getResultList();
        Comparator<Company> comparator = new Comparator<Company>() {
            @Override
            public int compare(Company o1, Company o2) {
                return (int) (o1.getId()-o2.getId());
            }
        };
        Collections.sort((List<Company>) companies, comparator); // use the comparator as much as u want
        return companies;
    }


}
