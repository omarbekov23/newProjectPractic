package peaksoft.Entity;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "localted_country")
    private String locatedCountry;

    @OneToMany(mappedBy = "company",cascade = {CascadeType.MERGE,CascadeType.REFRESH})
    private List<Course> courses;

    public Company() {
    }

    public Company(String companyName, String locatedCountry, List<Course> courses) {
        this.companyName = companyName;
        this.locatedCountry = locatedCountry;
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocatedCountry() {
        return locatedCountry;
    }

    public void setLocatedCountry(String locatedCountry) {
        this.locatedCountry = locatedCountry;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", locatedCountry='" + locatedCountry + '\'' +
                ", courses=" + courses +
                '}';
    }
}
