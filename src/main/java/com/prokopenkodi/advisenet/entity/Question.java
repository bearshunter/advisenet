package com.prokopenkodi.advisenet.entity;

import com.prokopenkodi.advisenet.classes.Status;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "QUESTION")
@Data
public class Question implements Serializable{
    @Id
    private Long id;

    private String header;

    private String message;

    @Column(name = "DATE_CREATE")
    private Timestamp createdDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    private QuestionType type;


}
