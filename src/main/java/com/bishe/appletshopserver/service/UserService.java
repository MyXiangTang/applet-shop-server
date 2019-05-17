package com.bishe.appletshopserver.service;

import com.bishe.appletshopserver.entity.LoginUser;
import com.bishe.appletshopserver.mapper.LoginUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author
 * @Description 登陆服务
 * @Date 2019/5/5
 */
@Service
public class UserService {

    @Autowired
    LoginUserMapper loginUserMapper;

    /**
     * 获取登陆用户信息
     *
     * @param userName
     * @return
     */
    public LoginUser findLoginUser(String userName) {
        return loginUserMapper.findLoginUser(userName);
    }

    /**
     * 获取所有登陆用户信息
     *
     * @param loginUser
     * @return
     */
    public List<LoginUser> findAllLoginUser(LoginUser loginUser) {
        return loginUserMapper.findAllLoginUser(loginUser);
    }

    /**
     * 获取所有登陆用户的总条数
     *
     * @param loginUser
     * @return
     */
    public int findAllLoginUserCount(LoginUser loginUser) {
        return loginUserMapper.findAllLoginUserCount(loginUser);
    }

    /**
     * 新增登陆用户信息
     *
     * @param loginUser
     * @return
     */
    public boolean saveLoginUser(LoginUser loginUser) {
        return loginUserMapper.saveLoginUser(loginUser);
    }

    /**
     * 编辑登陆用户信息
     *
     * @param loginUser
     * @return
     */
    public boolean editLoginUser(LoginUser loginUser) {
        return loginUserMapper.editLoginUser(loginUser);
    }

    /**
     * 批量删除登陆用户信息
     *
     * @param ids
     * @return
     */
    public boolean batchRemoveLoginUser(List<String> ids) {
        return loginUserMapper.batchRemoveLoginUser(ids);
    }
}