package com.bishe.appletshopserver.service;

import com.bishe.appletshopserver.entity.WxCustomer;
import com.bishe.appletshopserver.mapper.WxCustomerMapper;
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
public class WxCustomerService {

    @Autowired
    WxCustomerMapper wxCustomerMapper;

    /**
     * 获取所有微信顾客
     *
     * @param wxCustomer
     * @return
     */
    public List<WxCustomer> findAllWxCustomer(WxCustomer wxCustomer) {
        return wxCustomerMapper.findAllWxCustomer(wxCustomer);
    }

    /**
     * 获取所有微信顾客的总条数
     *
     * @param wxCustomer
     * @return
     */
    public int findAllWxCustomerCount(WxCustomer wxCustomer) {
        return wxCustomerMapper.findAllWxCustomerCount(wxCustomer);
    }

    /**
     * 新增微信顾客信息
     *
     * @param wxCustomer
     * @return
     */
    public boolean saveWxCustomer(WxCustomer wxCustomer) {
        return wxCustomerMapper.saveWxCustomer(wxCustomer);
    }

    /**
     * 编辑微信顾客信息
     *
     * @param wxCustomer
     * @return
     */
    public boolean editWxCustomer(WxCustomer wxCustomer) {
        return wxCustomerMapper.editWxCustomer(wxCustomer);
    }

    /**
     * 批量删除微信顾客信息
     *
     * @param ids
     * @return
     */
    public boolean batchRemoveWxCustomer(List<String> ids) {
        return wxCustomerMapper.batchRemoveWxCustomer(ids);
    }
}