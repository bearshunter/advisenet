package com.prokopenkodi.advisenet.bean;

import com.prokopenkodi.advisenet.api.UserAdapter;
import com.prokopenkodi.advisenet.classes.exception.AdvisenetException;
import com.prokopenkodi.advisenet.classes.ErrorData;
import com.prokopenkodi.advisenet.classes.exception.BadParamException;
import com.prokopenkodi.advisenet.classes.exception.NotFoundException;
import com.prokopenkodi.advisenet.dao.UserDAO;
import com.prokopenkodi.advisenet.entity.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Stateless
@SuppressWarnings("unused")
public class UserBean implements UserAdapter {

    @Inject
    private UserDAO dao;

    @Override
    public User get(Long userId) throws AdvisenetException {
        User user = dao.getById(userId);
        if(user == null){
            throw new NotFoundException();
        }
        return user;
    }

    @Override
    public ErrorData save(User user) {
        dao.save(user);
        return new ErrorData();
    }

    @Override
    public ErrorData update(User user) {
        dao.update(user);
        return new ErrorData();
    }

    @Override
    public ErrorData delete(Long userId) {
        dao.delete(userId);
        return new ErrorData();
    }

    @Override
    public User getByEmail(String email) throws AdvisenetException{
        if(!isEmailValid(email)){
            throw new BadParamException("email");
        }
        User user = dao.getByEmail(email);
        if(user == null){
            throw new NotFoundException();
        }
        return user;
    }

    private boolean isEmailValid(String email){
        String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
