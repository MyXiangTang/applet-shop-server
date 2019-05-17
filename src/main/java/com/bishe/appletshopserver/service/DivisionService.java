package com.bishe.appletshopserver.service;

import com.bishe.appletshopserver.entity.Division;
import com.bishe.appletshopserver.mapper.DivisionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author
 * @Description
 * @Date 2019/5/10
 * @Modify
 */
@Service
public class DivisionService {

    @Autowired
    DivisionMapper divisionMapper;

    /**
     * 获取所有商品分类信息
     *
     * @param division
     * @return
     */
    public List<Division> findAllDivision(Division division) {
        return divisionMapper.findAllDivision(division);
    }

    /**
     * 获取所有商品分类的总条数
     *
     * @param division
     * @return
     */
    public int findAllDivisionCount(Division division) {
        return divisionMapper.findAllDivisionCount(division);
    }

    /**
     * 新增商品分类信息
     *
     * @param division
     * @return
     */
    public boolean saveDivision(Division division) {
        return divisionMapper.saveDivision(division);
    }

    /**
     * 编辑商品分类信息
     *
     * @param division
     * @return
     */
    public boolean editDivision(Division division) {
        return divisionMapper.editDivision(division);
    }

    /**
     * 批量删除商品分类信息
     *
     * @param ids
     * @return
     */
    public boolean batchRemoveDivision(List<String> ids) {
        return divisionMapper.batchRemoveDivision(ids);
    }
}