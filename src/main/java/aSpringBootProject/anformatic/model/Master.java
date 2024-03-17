package aSpringBootProject.anformatic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Master")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    @NotBlank(message = "please enter your first name")
    private String name;


    @Column
    @NonNull
    @Email(message = "the email address is not correct,please check it")
    private String email;

    @Column
    @NonNull
    private String phoneNumber;

    @Column
    @NonNull
    private String field;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "master")
    private List<Course> course;

}
