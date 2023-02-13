package org.clone.videohosting.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "user_name", unique = true, nullable = false, length = 1000)
    private String userName;

    @Column(name = "email", unique = true, nullable = false, length = 1000)
    private String email;

    @Column(name = "password", nullable = false, length = 64)
    private String password;
}
