package com.prokopenkodi.advisenet.dao.impl;

import com.prokopenkodi.advisenet.dao.QuestionDAO;
import com.prokopenkodi.advisenet.entity.Question;
import com.prokopenkodi.advisenet.entity.QuestionType;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class QuestionDAOImpl implements QuestionDAO{


    @Override
    public boolean save(Question user) {
        return false;
    }

    @Override
    public boolean update(Question question) {
        return false;
    }

    @Override
    public boolean delete(Question question) {
        return false;
    }


    @Override
    public Question getById(Long id) {
        return null;
    }

    @Override
    public List<Question> findOpened() {
        return null;
    }

    @Override
    public List<QuestionType> getAllTypes() {
        return null;
    }
}
