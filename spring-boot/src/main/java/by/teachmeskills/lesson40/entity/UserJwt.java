package by.teachmeskills.lesson40.entity;

import jakarta.persistence.*;
import jdk.jshell.Snippet;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Accessors(chain = true)
@Data
@Entity
@Table(name = "users", schema = "tms")
@NamedEntityGraph(name = "User.role", attributeNodes = @NamedAttributeNode("role"))
public class UserJwt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String login;

    private String password;

    @Enumerated(EnumType.STRING)
    private Snippet.Status status;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

}