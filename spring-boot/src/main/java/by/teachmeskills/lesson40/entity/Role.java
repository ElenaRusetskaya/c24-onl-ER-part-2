package by.teachmeskills.lesson40.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "roles", schema = "tms")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
