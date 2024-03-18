package SpringBootProject.anformatic.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

@Entity
@Table(name = "User")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    @NonNull
    private String userName;

    @Column
    @NonNull
    private Long password;

    @Column
    private String userLogin;

   @OneToOne
    private Student student;

}
