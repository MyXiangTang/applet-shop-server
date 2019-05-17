package com.bishe.appletshopserver.controller;

import com.bishe.appletshopserver.entity.Division;
import com.bishe.appletshopserver.model.response.CommonResponse;
import com.bishe.appletshopserver.model.response.ReTurnT;
import com.bishe.appletshopserver.service.DivisionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @Author
 * @Description 商品分类
 * @Date 2019/5/10
 * @Modify
 */
@RestController
@RequestMapping("/division")
public class DivisionController {
    Logger LOGGER = LoggerFactory.getLogger("DivisionController");
    @Autowired
    DivisionService divisionService;


    /**
     * 查找商品分类
     *
     * @param division
     * @return
     */
    @PostMapping(value = "/listpage", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<CommonResponse<Division>> searchDivision(@RequestBody Division division) {
        try {
            LOGGER.info(division.toString());
            List<Division> divisionList = divisionService.findAllDivision(division);
            int total = divisionService.findAllDivisionCount(division);

            CommonResponse commonResponse = new CommonResponse();
            commonResponse.setContent(divisionList);
            commonResponse.setTotal(total);
            return new ReTurnT<>(commonResponse);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

    /**
     * 新增商品分类
     *
     * @param division
     * @return
     */
    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<String> saveDivision(@RequestBody Division division) {
        try {
            LOGGER.info(division.toString());
            divisionService.saveDivision(division);
            return ReTurnT.SUCCESS;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

    /**
     * 编辑商品分类
     *
     * @param division
     * @return
     */
    @PostMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<String> editDivision(@RequestBody Division division) {
        try {
            LOGGER.info(division.toString());
            divisionService.editDivision(division);
            return ReTurnT.SUCCESS;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

    /**
     * 批量删除商品分类
     *
     * @param ids
     * @return
     */
    @GetMapping(value = "/batchremove", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ReTurnT<String> batchRemoveDivision(String ids) {
        try {
            List<String> list = Arrays.asList(ids.split(","));
            divisionService.batchRemoveDivision(list);
            return ReTurnT.SUCCESS;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return ReTurnT.FAIL;
        }
    }

}