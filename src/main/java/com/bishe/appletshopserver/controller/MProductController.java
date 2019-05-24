package com.bishe.appletshopserver.controller;

import com.bishe.appletshopserver.entity.MProduct;
import com.bishe.appletshopserver.model.response.CommonResponse;
import com.bishe.appletshopserver.model.response.ReTurnT;
import com.bishe.appletshopserver.service.MProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @Author TomBing_Tang
 * @Description 商品信息
 * @Date 2019/5/10 9:45
 * @Modify
 */
@RestController
@RequestMapping("/mProduct")
public class MProductController {
    Logger LOGGER = LoggerFactory.getLogger("MProductController");
    @Autowired
    MProductService mProductService;


    /**
     * 查找商品档案
     *
     * @param mProduct
     * @return
     */
    @PostMapping(value = "/listpage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<CommonResponse<MProduct>> searchMProduct(@RequestBody MProduct mProduct) {
        try {
            List<MProduct> mProductList = mProductService.findAllMProduct(mProduct);
            int total = mProductService.findAllMProductCount(mProduct);

            CommonResponse commonResponse = new CommonResponse();
            commonResponse.setContent(mProductList);
            commonResponse.setTotal(total);
            return new ReTurnT<>(commonResponse);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

    /**
     * 新增商品档案
     *
     * @param mProduct
     * @return
     */
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<String> saveMProduct(@RequestBody MProduct mProduct) {
        try {
            LOGGER.info(mProduct.toString());
            mProductService.saveMProduct(mProduct);
            return ReTurnT.SUCCESS;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

    /**
     * 编辑商品档案
     *
     * @param mProduct
     * @return
     */
    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<String> editMProduct(@RequestBody MProduct mProduct) {
        try {
            LOGGER.info(mProduct.toString());
            mProductService.editMProduct(mProduct);
            return ReTurnT.SUCCESS;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

    /**
     * 批量删除商品档案
     *
     * @param ids
     * @return
     */
    @GetMapping(value = "/batchremove", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<String> batchRemoveMProduct(String ids) {
        try {
            List<String> list = Arrays.asList(ids.split(","));
            mProductService.batchRemoveMProduct(list);
            return ReTurnT.SUCCESS;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

}