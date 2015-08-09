package com.prokopenkodi.advisenet.dao;

import com.prokopenkodi.advisenet.entity.Question;
import com.prokopenkodi.advisenet.entity.QuestionType;

import java.util.List;

public interface QuestionDAO {

    boolean save(Question question);

    boolean update(Question question);

    boolean delete(Question question);

    Question getById(Long id);

    List<Question> findOpened();

    List<QuestionType> getAllTypes();

}
