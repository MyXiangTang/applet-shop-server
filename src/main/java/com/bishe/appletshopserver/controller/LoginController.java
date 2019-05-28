package com.bishe.appletshopserver.controller;

import com.bishe.appletshopserver.entity.LoginUser;
import com.bishe.appletshopserver.entity.WxCustomer;
import com.bishe.appletshopserver.model.request.LoginRequest;
import com.bishe.appletshopserver.model.response.LoginResponse;
import com.bishe.appletshopserver.model.response.ReTurnT;
import com.bishe.appletshopserver.service.UserService;
import com.bishe.appletshopserver.service.WxCustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    WxCustomerService wxCustomerService;

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

    /**
     * 微信登录
     *
     * @param code
     * @return
     */
    @PostMapping(value = "/wx", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<Map<String, String>> wxLogin(@RequestBody Map<String, String> code) {
        try {
            String token = userService.wxLogin(code.get("code"));

            WxCustomer unqionCustomer = new WxCustomer();
            unqionCustomer.setOpenId(token);
//            查看是否存在该顾客
            List<WxCustomer> wxCustomerList = wxCustomerService.findAllWxCustomer(unqionCustomer);
            String userId;
            Map<String, String> map = new HashMap<>();
            if (!CollectionUtils.isEmpty(wxCustomerList)) {
                userId = wxCustomerList.get(0).getId();
                map.put("userId", userId);
            }
            map.put("token", token);
//            返回token
            return new ReTurnT<>(ReTurnT.SUCCESS_CODE, "SUCCESS",map);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }
}