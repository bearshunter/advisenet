package com.prokopenkodi.advisenet.dao;

import com.prokopenkodi.advisenet.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO implements IUserDao {


    public UserDAO(MongoOperations mongoOps){
        this.mongoOps=mongoOps;
    }

    @Autowired
    private MongoOperations mongoOps;

    public void save(){
        mongoOps.save(new User());
    }
}
