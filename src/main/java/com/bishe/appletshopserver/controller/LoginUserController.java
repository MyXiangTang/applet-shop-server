package com.bishe.appletshopserver.controller;

import com.bishe.appletshopserver.entity.LoginUser;
import com.bishe.appletshopserver.model.response.LoginUserResponse;
import com.bishe.appletshopserver.model.response.ReTurnT;
import com.bishe.appletshopserver.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @Author 操作web登陆用户
 * @Description
 * @Date 2019/5/7
 * @Modify
 */

@RestController
@RequestMapping("/loginUser")
public class LoginUserController {

    Logger LOGGER = LoggerFactory.getLogger("LoginUserController");

    @Autowired
    UserService userService;

    /**
     * 查找登陆用户
     *
     * @param loginUser
     * @return
     */
    @PostMapping(value = "/listpage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<LoginUserResponse> searchLoginUser(@RequestBody LoginUser loginUser) {
        try {
//            LOGGER.info(loginUser.toString());
            List<LoginUser> loginUserList = userService.findAllLoginUser(loginUser);
            int total = userService.findAllLoginUserCount(loginUser);

            LoginUserResponse loginUserResponse = new LoginUserResponse();
            loginUserResponse.setLoginUserList(loginUserList);
            loginUserResponse.setTotal(total);
            return new ReTurnT<>(loginUserResponse);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

    /**
     * 新增登陆用户
     *
     * @param loginUser
     * @return
     */
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<String> saveLoginUser(@RequestBody LoginUser loginUser) {
        try {
            LOGGER.info(loginUser.toString());
            userService.saveLoginUser(loginUser);
            return ReTurnT.SUCCESS;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

    /**
     * 编辑登陆用户
     *
     * @param loginUser
     * @return
     */
    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<String> editLoginUser(@RequestBody LoginUser loginUser) {
        try {
            LOGGER.info(loginUser.toString());
            userService.editLoginUser(loginUser);
            return ReTurnT.SUCCESS;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

    /**
     * 批量删除登陆用户
     *
     * @param ids
     * @return
     */
    @GetMapping(value = "/batchremove", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<String> batchRemoveLoginUser(String ids) {
        try {
            List<String> list = Arrays.asList(ids.split(","));
            userService.batchRemoveLoginUser(list);
            return ReTurnT.SUCCESS;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

}