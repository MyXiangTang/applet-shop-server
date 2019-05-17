package com.bishe.appletshopserver.mapper;

import com.bishe.appletshopserver.entity.Division;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author
 * @Description
 * @Date 2019/5/10
 * @Modify
 */
@Mapper
@Component(value = "divisionMapper")
public interface DivisionMapper {

    /**
     * 查找所有商品分类
     *
     * @return
     */
    List<Division> findAllDivision(Division division);

    /**
     * 查找所有商品分类总条数
     *
     * @return
     */
    int findAllDivisionCount(Division division);

    /**
     * 新增商品分类
     *
     * @param division
     * @return
     */
    boolean saveDivision(Division division);

    /**
     * 编辑商品分类
     *
     * @param division
     * @return
     */
    boolean editDivision(Division division);

    /**
     * 批量删除登陆商品分类信息
     * @param ids
     * @return
     */
    boolean batchRemoveDivision(List<String> ids);
}