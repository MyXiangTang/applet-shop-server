package com.bishe.appletshopserver.service;

import com.bishe.appletshopserver.entity.MProduct;
import com.bishe.appletshopserver.mapper.MProductMapper;
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
public class MProductService {

    @Autowired
    MProductMapper mProductMapper;

    /**
     * 获取所有商品档案
     *
     * @param mProduct
     * @return
     */
    public List<MProduct> findAllMProduct(MProduct mProduct) {
        return mProductMapper.findAllMProduct(mProduct);
    }

    /**
     * 获取所有商品档案的总条数
     *
     * @param mProduct
     * @return
     */
    public int findAllMProductCount(MProduct mProduct) {
        return mProductMapper.findAllMProductCount(mProduct);
    }

    /**
     * 新增商品档案信息
     *
     * @param mProduct
     * @return
     */
    public boolean saveMProduct(MProduct mProduct) {
        return mProductMapper.saveMProduct(mProduct);
    }

    /**
     * 编辑商品档案信息
     *
     * @param mProduct
     * @return
     */
    public boolean editMProduct(MProduct mProduct) {
        return mProductMapper.editMProduct(mProduct);
    }

    /**
     * 批量删除商品档案信息
     *
     * @param ids
     * @return
     */
    public boolean batchRemoveMProduct(List<String> ids) {
        return mProductMapper.batchRemoveMProduct(ids);
    }
}