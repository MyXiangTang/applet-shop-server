package com.bishe.appletshopserver.mapper;

import com.bishe.appletshopserver.entity.MSale;
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
@Component(value = "mSaleMapper")
public interface MSaleMapper {

    /**
     * 查找所有订单信息
     *
     * @return
     */
    List<MSale> findAllMSale(MSale mSale);

    /**
     * 查找所有订单信息总条数
     *
     * @return
     */
    int findAllMSaleCount(MSale mSale);

    /**
     * 新增订单信息
     *
     * @param mSale
     * @return
     */
    boolean saveMSale(MSale mSale);

    /**
     * 编辑订单信息
     *
     * @param mSale
     * @return
     */
    boolean editMSale(MSale mSale);

    /**
     * 批量删除订单信息信息
     * @param ids
     * @return
     */
    boolean batchRemoveMSale(List<String> ids);
}
