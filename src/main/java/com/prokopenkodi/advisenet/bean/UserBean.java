package com.prokopenkodi.advisenet.bean;

import com.prokopenkodi.advisenet.api.UserAdapter;
import com.prokopenkodi.advisenet.classes.ErrorCode;
import com.prokopenkodi.advisenet.classes.ErrorData;
import com.prokopenkodi.advisenet.classes.response.BaseResponse;
import com.prokopenkodi.advisenet.classes.response.GetUserResponse;
import com.prokopenkodi.advisenet.dao.UserDAO;
import com.prokopenkodi.advisenet.entity.User;
import com.prokopenkodi.advisenet.util.ValidationUtil;

import javax.ejb.Stateless;
import javax.inject.Inject;

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
    public BaseResponse save(User user) {
        if (dao.save(user)) {
            return new BaseResponse();
        } else {
            return new BaseResponse(ErrorCode.DUPLICATED_PARAM);
        }
    }

    @Override
    public BaseResponse update(User user) {
        if (dao.update(user)) {
            return new BaseResponse();
        } else {
            return new BaseResponse(ErrorCode.INVALID_PARAM);
        }
    }

    @Override
    public BaseResponse delete(Long userId) {
        if (dao.update(get(userId).getUser())) {
            return new BaseResponse();
        } else {
            return new BaseResponse(ErrorCode.INTERNAL_ERROR);
        }
    }

    @Override
    public GetUserResponse getByEmail(String email) {
        if (!ValidationUtil.isEmailValid(email)) {
            return new GetUserResponse(new ErrorData(ErrorCode.INVALID_PARAM));
        }
        User user = dao.getByEmail(email);
        if (user == null) {
            return new GetUserResponse(new ErrorData(ErrorCode.NOT_FOUND));
        }
        return  new GetUserResponse(user);
    }


}
