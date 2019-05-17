package com.bishe.appletshopserver.mapper;

import com.bishe.appletshopserver.entity.LoginUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author
 * @Description
 * @Date 2019/5/5
 * @Modify
 */
@Mapper
@Component(value = "loginUserMapper")
public interface LoginUserMapper {

    /**
     * 查找用户
     *
     * @return
     */
    LoginUser findLoginUser(String userName);

    /**
     * 查找所有用户
     *
     * @return
     */
    List<LoginUser> findAllLoginUser(LoginUser loginUser);

    /**
     * 查找所有用户总条数
     *
     * @return
     */
    int findAllLoginUserCount(LoginUser loginUser);

    /**
     * 新增用户
     *
     * @param loginUser
     * @return
     */
    boolean saveLoginUser(LoginUser loginUser);

    /**
     * 编辑用户
     *
     * @param loginUser
     * @return
     */
    boolean editLoginUser(LoginUser loginUser);

    /**
     * 批量删除登陆用户信息
     * @param ids
     * @return
     */
    boolean batchRemoveLoginUser(List<String> ids);
}