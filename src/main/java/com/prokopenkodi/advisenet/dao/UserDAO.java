package com.prokopenkodi.advisenet.dao;

import com.prokopenkodi.advisenet.entity.User;

public interface UserDAO {

    boolean save(User user);

    boolean update(User user);

    boolean delete(User user);

    User getByEmail(String email);

    User getById(Long id);
}
