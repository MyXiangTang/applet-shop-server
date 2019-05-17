package com.bishe.appletshopserver.mapper;

import com.bishe.appletshopserver.entity.WxCustomer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author
 * @Description ${description}
 * @Date 2019/5/10
 * @Modify
 */
@Mapper
@Component(value = "wxCustomerMapper")
public interface WxCustomerMapper {

    /**
     * 查找所有微信用户
     *
     * @return
     */
    List<WxCustomer> findAllWxCustomer(WxCustomer wxCustomer);

    /**
     * 查找所有微信用户总条数
     *
     * @return
     */
    int findAllWxCustomerCount(WxCustomer wxCustomer);

    /**
     * 新增微信用户
     *
     * @param wxCustomer
     * @return
     */
    boolean saveWxCustomer(WxCustomer wxCustomer);

    /**
     * 编辑微信用户
     *
     * @param wxCustomer
     * @return
     */
    boolean editWxCustomer(WxCustomer wxCustomer);

    /**
     * 批量删除微信用户信息
     * @param ids
     * @return
     */
    boolean batchRemoveWxCustomer(List<String> ids);
}
