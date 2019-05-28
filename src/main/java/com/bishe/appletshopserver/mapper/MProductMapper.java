package com.bishe.appletshopserver.mapper;

import com.bishe.appletshopserver.entity.MProduct;
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
@Component(value = "mProductMapper")
public interface MProductMapper {

    /**
     * 查找所有商品档案
     *
     * @return
     */
    List<MProduct> findAllMProduct(MProduct mProduct);

    /**
     * 查找所有商品档案总条数
     *
     * @return
     */
    int findAllMProductCount(MProduct mProduct);

    /**
     * 新增商品档案
     *
     * @param mProduct
     * @return
     */
    boolean saveMProduct(MProduct mProduct);

    /**
     * 编辑商品档案
     *
     * @param mProduct
     * @return
     */
    boolean editMProduct(MProduct mProduct);

    /**
     * 批量删除商品档案信息
     * @param ids
     * @return
     */
    boolean batchRemoveMProduct(List<String> ids);

    /**
     * 查找微信人气商品档案
     * @return
     */
    List<MProduct> getPopularProduct();
}