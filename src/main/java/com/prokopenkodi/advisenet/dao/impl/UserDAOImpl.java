package com.prokopenkodi.advisenet.dao.impl;

import com.prokopenkodi.advisenet.dao.UserDAO;
import com.prokopenkodi.advisenet.entity.User;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class UserDAOImpl implements UserDAO {

    @PersistenceContext(unitName = "AdvisenetPU")
    private EntityManager entityManager;


    @Override
    public boolean save(User user) {
        try{
            entityManager.persist(user);
        } catch (Exception ex){
           return false;
        }
        return true;
    }

    @Override
    public boolean update(User user) {
        try{
            entityManager.merge(user);
        } catch (Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(User user) {
        try{
            entityManager.remove(user);
        } catch (Exception ex){
            return false;
        }
        return true;

    }

    @Override
    public User getByEmail(String email) {
        TypedQuery<User> query = entityManager.createNamedQuery("User.getByEmail", User.class);
        query.setParameter("email", email);
        try {
            return query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public User getById(Long id) {
        TypedQuery<User> query = entityManager.createNamedQuery("User.getById", User.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }
}
