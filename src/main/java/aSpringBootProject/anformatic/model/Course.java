package aSpringBootProject.anformatic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Course")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    @Min(value = 1)
    @Max(value = 3)
    private short unit;


    @Column
    @NonNull
    @NotBlank(message = "title can not be empty,please fill the blank")
    private String title;

    @ManyToOne()
    private Master master;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Student> studentId=new HashSet<>();

    public Course(Long id, @NonNull short unit, @NonNull String title) {
        this.id = id;
        this.unit = unit;
        this.title = title;
    }

    public Course(Long id, @NonNull short unit, @NonNull String title, Master master) {
        this.id = id;
        this.unit = unit;
        this.title = title;
        this.master = master;
    }

}
