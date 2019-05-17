package com.bishe.appletshopserver.controller;

import com.bishe.appletshopserver.entity.LoginUser;
import com.bishe.appletshopserver.model.request.LoginRequest;
import com.bishe.appletshopserver.model.response.LoginResponse;
import com.bishe.appletshopserver.model.response.ReTurnT;
import com.bishe.appletshopserver.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author
 * @Description 登陆
 * @Date 2019/4/28
 * @Modify
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    Logger LOGGER = LoggerFactory.getLogger("LoginController");

    @Autowired
    UserService userService;

    /**
     * Web端登陆验证
     *
     * @param loginRequest
     * @return
     */
    @PostMapping(value = "/web", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<LoginResponse> login(@RequestBody LoginRequest loginRequest, HttpServletRequest httpServletRequest) {
        try {
            LoginUser loginUser = userService.findLoginUser(loginRequest.getUsername());
            if (loginUser != null) {
                if (loginUser.getPassword().equals(loginRequest.getPassword())) {
                    LOGGER.info("登陆用户" + loginRequest);
                    return new ReTurnT<>(ReTurnT.SUCCESS_CODE, "SUCCESS", new LoginResponse(loginRequest.getUsername(), "http://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort() + "/images/" + loginRequest.getUsername() + ".png"));
                } else {
                    return new ReTurnT<>(ReTurnT.FAIL_CODE, "密码错误！");
                }
            } else {
                return new ReTurnT<>(ReTurnT.FAIL_CODE, "用户不存在");
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }
}