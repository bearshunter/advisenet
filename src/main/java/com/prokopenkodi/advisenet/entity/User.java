package com.prokopenkodi.advisenet.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlRootElement;

@Document(collection = "user")
@XmlRootElement
@Data
public class User {

    @Id
    private Long id;

    private String email;
    private String password;
    private String nickname;
}
