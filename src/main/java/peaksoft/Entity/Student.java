package peaksoft.Entity;

import peaksoft.enam.StudyFormat;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "email")
    private String email;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "study_fomat")
    private StudyFormat studyFormat;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "group_id")
    private Group groups;

    public Student() {
    }

    public Student(String firstName, String email, String lastName, StudyFormat studyFormat, Group groups) {
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
        this.studyFormat = studyFormat;
        this.groups = groups;
    }

    public Student(String firstName, String email, String lastName, StudyFormat studyFormat) {
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
        this.studyFormat = studyFormat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Group getGroups() {
        return groups;
    }

    public void setGroups(Group groups) {
        this.groups = groups;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public StudyFormat getStudyFormat() {
        return studyFormat;
    }

    public void setStudyFormat(StudyFormat studyFormat) {
        this.studyFormat = studyFormat;
    }

    public Group getGroup() {
        return groups;
    }

    public void setGroup(Group groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studyFormat=" + studyFormat +
                ", groups=" + groups +
                '}';
    }
}
