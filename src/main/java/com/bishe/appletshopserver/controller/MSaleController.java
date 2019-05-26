package com.bishe.appletshopserver.controller;

import com.bishe.appletshopserver.entity.MSale;
import com.bishe.appletshopserver.model.response.CommonResponse;
import com.bishe.appletshopserver.model.response.ReTurnT;
import com.bishe.appletshopserver.service.MSaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @Author
 * @Description 订单信息
 * @Date 2019/5/10
 * @Modify
 */
@RestController
@RequestMapping("/sale")
public class MSaleController {
    Logger LOGGER = LoggerFactory.getLogger("MSaleController");
    @Autowired
    MSaleService mSaleService;


    /**
     * 查找订单信息
     *
     * @param mSale
     * @return
     */
    @PostMapping(value = "/listpage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<CommonResponse<MSale>> searchMSale(@RequestBody MSale mSale) {
        try {
            LOGGER.info(mSale.toString());
            List<MSale> mSaleList = mSaleService.findAllMSale(mSale);
            int total = mSaleService.findAllMSaleCount(mSale);

            CommonResponse commonResponse = new CommonResponse();
            commonResponse.setContent(mSaleList);
            commonResponse.setTotal(total);
            return new ReTurnT<>(commonResponse);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

    /**
     * 新增订单信息
     *
     * @param mSale
     * @return
     */
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<String> saveMSale(@RequestBody MSale mSale) {
        try {
            LOGGER.info(mSale.toString());
            mSaleService.saveMSale(mSale);
            return ReTurnT.SUCCESS;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

    /**
     * 编辑订单信息
     *
     * @param mSale
     * @return
     */
    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<String> editMSale(@RequestBody MSale mSale) {
        try {
            LOGGER.info(mSale.toString());
            mSaleService.editMSale(mSale);
            return ReTurnT.SUCCESS;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

    /**
     * 批量删除订单信息
     *
     * @param ids
     * @return
     */
    @GetMapping(value = "/batchremove", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<String> batchRemoveMSale(String ids) {
        try {
            List<String> list = Arrays.asList(ids.split(","));
            mSaleService.batchRemoveMSale(list);
            return ReTurnT.SUCCESS;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

}