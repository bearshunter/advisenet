package com.prokopenkodi.advisenet.entity;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

@Entity
@Table(name = "USERS")
@Data
@NamedQueries({
        @NamedQuery(name = "User.getById",
                query = "SELECT u FROM User u WHERE u.id = :id"),
        @NamedQuery(name = "User.getByEmail",
                query = "SELECT u FROM User u WHERE u.email = :email"),
})
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String login;
}
