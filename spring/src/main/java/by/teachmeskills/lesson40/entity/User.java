package by.teachmeskills.lesson40.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Table(name = "users")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "name")
    private String name;
    @Column(name = "passwird")
    private String password;
    @Column(name = "email")
    private String email;

    public User(User user) {
        this.name = user.getName();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }
}
