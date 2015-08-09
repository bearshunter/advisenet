package com.prokopenkodi.advisenet.bean;

import com.prokopenkodi.advisenet.api.UserAdapter;
import com.prokopenkodi.advisenet.classes.ErrorCode;
import com.prokopenkodi.advisenet.classes.ErrorData;
import com.prokopenkodi.advisenet.classes.response.GetUserResponse;
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
    public GetUserResponse get(Long userId) {
        User user = dao.getById(userId);
        if (user != null) {
            return new GetUserResponse(user);
        } else {
            return new GetUserResponse(new ErrorData(ErrorCode.NOT_FOUND));
        }
    }

    @Override
    public ErrorData save(User user) {
        if (dao.save(user)) {
            return new ErrorData();
        } else {
            return new ErrorData(ErrorCode.DUPLICATED_PARAM);
        }
    }

    @Override
    public ErrorData update(User user) {
        if (dao.update(user)) {
            return new ErrorData();
        } else {
            return new ErrorData(ErrorCode.INVALID_PARAM);
        }
    }

    @Override
    public ErrorData delete(Long userId) {
        if (dao.update(get(userId).getUser())) {
            return new ErrorData();
        } else {
            return new ErrorData(ErrorCode.INTERNAL_ERROR);
        }
    }

    @Override
    public GetUserResponse getByEmail(String email) {
        if (!isEmailValid(email)) {
            return new GetUserResponse(new ErrorData(ErrorCode.INVALID_PARAM));
        }
        User user = dao.getByEmail(email);
        if (user == null) {
            return new GetUserResponse(new ErrorData(ErrorCode.NOT_FOUND));
        }
        return  new GetUserResponse(user);
    }

    private boolean isEmailValid(String email) {
        String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
