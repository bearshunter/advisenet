package com.prokopenkodi.advisenet.dao.impl;

import com.prokopenkodi.advisenet.dao.UserDAO;
import com.prokopenkodi.advisenet.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class UserDAOImpl implements UserDAO {

    @PersistenceContext(unitName = "AdvisenetPU")
    private EntityManager entityManager;


    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(getById(id));

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
