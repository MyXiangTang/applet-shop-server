package com.bishe.appletshopserver.controller;

import com.bishe.appletshopserver.entity.WxCustomer;
import com.bishe.appletshopserver.model.response.CommonResponse;
import com.bishe.appletshopserver.model.response.ReTurnT;
import com.bishe.appletshopserver.service.WxCustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @Author
 * @Description 微信用户
 * @Date 2019/5/10
 * @Modify
 */
@RestController
@RequestMapping("/customer")
public class WxCustomerController {
    Logger LOGGER = LoggerFactory.getLogger("WxCustomerController");
    @Autowired
    WxCustomerService wxCustomerService;


    /**
     * 查找微信顾客
     *
     * @param wxCustomer
     * @return
     */
    @PostMapping(value = "/listpage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<CommonResponse<WxCustomer>> searchWxCustomer(@RequestBody WxCustomer wxCustomer) {
        try {
            LOGGER.info(wxCustomer.toString());
            List<WxCustomer> wxCustomerList = wxCustomerService.findAllWxCustomer(wxCustomer);
            int total = wxCustomerService.findAllWxCustomerCount(wxCustomer);

            CommonResponse commonResponse = new CommonResponse();
            commonResponse.setContent(wxCustomerList);
            commonResponse.setTotal(total);
            return new ReTurnT<>(commonResponse);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

    /**
     * 新增微信顾客
     *
     * @param wxCustomer
     * @return
     */
    @PostMapping(value = "/wxRegister", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<String> saveWxCustomer(@RequestBody WxCustomer wxCustomer, HttpServletRequest request) {
        try {
            wxCustomer.setOpenId(request.getHeader("token"));
            LOGGER.info(wxCustomer.toString());
            WxCustomer unqionCustomer=new WxCustomer();
            unqionCustomer.setOpenId(request.getHeader("token"));
//            查看是否存在该顾客
            List<WxCustomer> wxCustomerList = wxCustomerService.findAllWxCustomer(unqionCustomer);
            if (CollectionUtils.isEmpty(wxCustomerList)) {
//              第一次注册，则插入
                wxCustomerService.saveWxCustomer(wxCustomer);
            } else {
//                修改保存
                wxCustomerService.editWxCustomer(wxCustomer);
            }
//            返回用户ID
            wxCustomerList = wxCustomerService.findAllWxCustomer(unqionCustomer);
            return new ReTurnT(ReTurnT.SUCCESS_CODE, "SUCCESS", wxCustomerList.get(0).getId());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

    /**
     * 编辑微信顾客
     *
     * @param wxCustomer
     * @return
     */
    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<String> editWxCustomer(@RequestBody WxCustomer wxCustomer) {
        try {
            LOGGER.info(wxCustomer.toString());
            wxCustomerService.editWxCustomer(wxCustomer);
            return ReTurnT.SUCCESS;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

    /**
     * 批量删除微信顾客
     *
     * @param ids
     * @return
     */
    @GetMapping(value = "/batchremove", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<String> batchRemoveWxCustomer(String ids) {
        try {
            List<String> list = Arrays.asList(ids.split(","));
            wxCustomerService.batchRemoveWxCustomer(list);
            return ReTurnT.SUCCESS;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

}