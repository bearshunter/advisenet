package com.prokopenkodi.advisenet.dao;

import com.prokopenkodi.advisenet.entity.User;

public interface UserDAO {

    void save(User user);

    void update(User user);

    void delete(Long id);

    User getByEmail(String email);

    User getById(Long id);
}
