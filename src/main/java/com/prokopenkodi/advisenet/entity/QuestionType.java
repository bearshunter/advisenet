package com.prokopenkodi.advisenet.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "QUESTION_TYPE")
@Data
public class QuestionType implements Serializable {

    @Id
    private Long id;

    private String name;

}
