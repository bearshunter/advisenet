package com.prokopenkodi.advisenet.entity;

import com.prokopenkodi.advisenet.classes.Status;
import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "QUESTION")
@Data
@NamedQueries({
        @NamedQuery(name = "Question.getById", query = "SELECT q FROM Question  q WHERE q.id = :id")
})

public class Question implements Serializable{
    @Id
    private Long id;

    private String header;

    private String message;

    @Column(name = "DATE_CREATE")
    private Timestamp createdDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name="TYPE")
    private QuestionType type;


}
