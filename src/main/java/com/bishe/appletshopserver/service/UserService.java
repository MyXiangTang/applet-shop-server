package com.bishe.appletshopserver.service;

import com.alibaba.fastjson.JSONObject;
import com.bishe.appletshopserver.entity.LoginUser;
import com.bishe.appletshopserver.mapper.LoginUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    @Autowired
    RestTemplate restTemplate;

    @Value("${wx.auth.appId}")
    private String appId;

    @Value("${wx.auth.secret}")
    private String secret;

    Logger LOGGER = LoggerFactory.getLogger(UserService.class);

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

    /**
     * 微信用户登录
     *
     * @param code
     * @return
     */
    private static final String CODE2SESSION_URL = "https://api.weixin.qq.com/sns/jscode2session";

    public String wxLogin(String code) {
        StringBuffer buf = new StringBuffer(CODE2SESSION_URL);
        buf.append("?").append("appid=").append(appId)
                .append("&secret=").append(secret)
                .append("&js_code=").append(code)
                .append("&grant_type=authorization_code");
        String url = buf.toString();
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
//        获取微信返回的用户唯一id{"session_key":"mS1z5JiVjqea2EIdUADzmw==","openid":"of9Er5G3cXIa0Yje_Dlz0XdOFoAI"}
        LOGGER.info(result.getBody());
        JSONObject jsonObject = JSONObject.parseObject(result.getBody());
        return "openid" + jsonObject.getString("openid");
    }
}