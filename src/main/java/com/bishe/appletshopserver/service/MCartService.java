package com.bishe.appletshopserver.service;

import com.bishe.appletshopserver.entity.MCart;
import com.bishe.appletshopserver.mapper.MCartMapper;
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
public class MCartService {

    @Autowired
    MCartMapper mCartMapper;

    /**
     * 获取所有购物车
     *
     * @param mCart
     * @return
     */
    public List<MCart> findAllMCart(MCart mCart) {
        return mCartMapper.findAllMCart(mCart);
    }

    /**
     * 获取所有购物车的总条数
     *
     * @param mCart
     * @return
     */
    public int findAllMCartCount(MCart mCart) {
        return mCartMapper.findAllMCartCount(mCart);
    }

    /**
     * 新增购物车信息
     *
     * @param mCart
     * @return
     */
    public boolean saveMCart(MCart mCart) {
        return mCartMapper.saveMCart(mCart);
    }

    /**
     * 编辑购物车信息
     *
     * @param mCart
     * @return
     */
    public boolean editMCart(MCart mCart) {
        return mCartMapper.editMCart(mCart);
    }

    /**
     * 批量删除购物车信息
     *
     * @param ids
     * @return
     */
    public boolean batchRemoveMCart(List<String> ids) {
        return mCartMapper.batchRemoveMCart(ids);
    }
}