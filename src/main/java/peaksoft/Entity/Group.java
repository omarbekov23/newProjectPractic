package peaksoft.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "data_of_start")
    private String dataOfStart;

    @Column(name = "data_of_finish")
    private String dataOfFinish;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "group_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Course> course;

    @OneToMany(mappedBy = "groups",
    cascade = CascadeType.ALL)
    private List<Student> students;

    public Group() {
    }

    public Group(String groupName, String dataOfStart, String dataOfFinish, List<Course> course, List<Student> students) {
        this.groupName = groupName;
        this.dataOfStart = dataOfStart;
        this.dataOfFinish = dataOfFinish;
        this.course = course;
        this.students = students;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDataOfStart() {
        return dataOfStart;
    }

    public void setDataOfStart(String dataOfStart) {
        this.dataOfStart = dataOfStart;
    }

    public String getDataOfFinish() {
        return dataOfFinish;
    }

    public void setDataOfFinish(String dataOfFinish) {
        this.dataOfFinish = dataOfFinish;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", dataOfStart='" + dataOfStart + '\'' +
                ", dataOfFinish='" + dataOfFinish + '\'' +
                ", course=" + course +
                ", students=" + students +
                '}';
    }
}
