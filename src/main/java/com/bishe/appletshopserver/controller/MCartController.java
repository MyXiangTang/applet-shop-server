package com.bishe.appletshopserver.controller;

import com.bishe.appletshopserver.entity.MCart;
import com.bishe.appletshopserver.model.response.CommonResponse;
import com.bishe.appletshopserver.model.response.ReTurnT;
import com.bishe.appletshopserver.service.MCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @Author
 * @Description 购物车
 * @Date 2019/5/10
 * @Modify
 */
@RestController
@RequestMapping("/cart")
public class MCartController {
    Logger LOGGER = LoggerFactory.getLogger("MCartController");
    @Autowired
    MCartService mCartService;


    /**
     * 查找购物车
     *
     * @param mCart
     * @return
     */
    @PostMapping(value = "/listpage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<CommonResponse<MCart>> searchMCart(@RequestBody MCart mCart) {
        try {
            LOGGER.info(mCart.toString());
            List<MCart> mCartList = mCartService.findAllMCart(mCart);
            int total = mCartService.findAllMCartCount(mCart);

            CommonResponse commonResponse = new CommonResponse();
            commonResponse.setContent(mCartList);
            commonResponse.setTotal(total);
            return new ReTurnT<>(commonResponse);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

    /**
     * 新增购物车
     *
     * @param mCart
     * @return
     */
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<String> saveMCart(@RequestBody MCart mCart) {
        try {
            LOGGER.info(mCart.toString());
            mCartService.saveMCart(mCart);
            return ReTurnT.SUCCESS;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

    /**
     * 编辑购物车
     *
     * @param mCart
     * @return
     */
    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<String> editMCart(@RequestBody MCart mCart) {
        try {
            LOGGER.info(mCart.toString());
            mCartService.editMCart(mCart);
            return ReTurnT.SUCCESS;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

    /**
     * 批量删除购物车
     *
     * @param ids
     * @return
     */
    @GetMapping(value = "/batchremove", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<String> batchRemoveMCart(String ids) {
        try {
            List<String> list = Arrays.asList(ids.split(","));
            mCartService.batchRemoveMCart(list);
            return ReTurnT.SUCCESS;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

}