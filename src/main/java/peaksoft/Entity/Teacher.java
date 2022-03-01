package peaksoft.Entity;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {


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

    @OneToOne(mappedBy = "teacher",
    cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    private Course course;

    public Teacher() {
    }

    public Teacher(String firstName, String email, String lastName) {
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
    }

    public Teacher(String firstName, String email, String lastName, Course course) {
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", course=" + course +
                '}';
    }
}
