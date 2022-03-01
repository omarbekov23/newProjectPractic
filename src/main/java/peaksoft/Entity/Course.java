package peaksoft.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "duration")
    private int duration;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Company company;

    @ManyToMany(mappedBy = "course",cascade = {CascadeType.MERGE})
    private List<Group> groups;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Course() {
    }

    public Course(String courseName, int duration, Company company, List<Group> groups, Teacher teacher) {
        this.courseName = courseName;
        this.duration = duration;
        this.company = company;
        this.groups = groups;
        this.teacher = teacher;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", duration=" + duration +
                ", company=" + company +
                ", groups=" + groups +
                ", teacher=" + teacher +
                '}';
    }
}
