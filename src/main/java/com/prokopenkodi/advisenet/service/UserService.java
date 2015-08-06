package com.prokopenkodi.advisenet.service;

import com.prokopenkodi.advisenet.entity.User;
import com.prokopenkodi.advisenet.rest.IUser;
import com.prokopenkodi.advisenet.rest.result.ErrorData;
import org.springframework.stereotype.Service;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/user")
@Produces("application/json")
@Consumes("application/json")
@Service
public class UserService implements IUser {

    @Override
    public User get(Long userId) {
        return new User();
    }

    @Override
    public ErrorData add(User user) {
        return new ErrorData();
    }

    @Override
    public ErrorData update(User user) {
        return new ErrorData();
    }

    @Override
    public ErrorData delete(Long userId) {
        return new ErrorData();
    }

    @Override
    public String ping() {
        return "OK";
    }
}
