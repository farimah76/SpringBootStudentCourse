package SpringBootProject.anformatic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Student")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    @NotBlank(message = "please enter your first name")
    private String name;


    @Column
    @NonNull
    private String phoneNumber;

    @Column
    @NonNull
    private String address;

    @Column
    @NonNull
    private String userName;
    @Column
    @NonNull
    private String idCode;
    @Column
    @NonNull
    private String email;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinTable(name = "student_course",joinColumns = {@JoinColumn(name = "student_id",referencedColumnName = "id")}
            ,inverseJoinColumns = {@JoinColumn(name = "course_id",referencedColumnName = "id")})
    private Set<Course> courses=new HashSet<>();


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "master_id", referencedColumnName = "id")
    private Master master;

    public Student(Long id, @NonNull String name, @NonNull String phoneNumber, @NonNull String address, @NonNull String userName, @NonNull String idCode, @NonNull String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.userName = userName;
        this.idCode = idCode;
        this.email = email;
    }
}
