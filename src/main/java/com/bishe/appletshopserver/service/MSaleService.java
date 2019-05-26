package com.bishe.appletshopserver.service;

import com.bishe.appletshopserver.entity.MSale;
import com.bishe.appletshopserver.mapper.MSaleMapper;
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
public class MSaleService {

    @Autowired
    MSaleMapper mSaleMapper;

    /**
     * 获取所有订单信息
     *
     * @param mSale
     * @return
     */
    public List<MSale> findAllMSale(MSale mSale) {
        return mSaleMapper.findAllMSale(mSale);
    }

    /**
     * 获取所有订单信息的总条数
     *
     * @param mSale
     * @return
     */
    public int findAllMSaleCount(MSale mSale) {
        return mSaleMapper.findAllMSaleCount(mSale);
    }

    /**
     * 新增订单信息信息
     *
     * @param mSale
     * @return
     */
    public boolean saveMSale(MSale mSale) {
        return mSaleMapper.saveMSale(mSale);
    }

    /**
     * 编辑订单信息信息
     *
     * @param mSale
     * @return
     */
    public boolean editMSale(MSale mSale) {
        return mSaleMapper.editMSale(mSale);
    }

    /**
     * 批量删除订单信息信息
     *
     * @param ids
     * @return
     */
    public boolean batchRemoveMSale(List<String> ids) {
        return mSaleMapper.batchRemoveMSale(ids);
    }
}