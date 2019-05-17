package com.bishe.appletshopserver.mapper;

import com.bishe.appletshopserver.entity.MCart;
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
@Component(value = "mCartMapper")
public interface MCartMapper {

    /**
     * 查找所有购物车
     *
     * @return
     */
    List<MCart> findAllMCart(MCart mCart);

    /**
     * 查找所有购物车总条数
     *
     * @return
     */
    int findAllMCartCount(MCart mCart);

    /**
     * 新增购物车
     *
     * @param mCart
     * @return
     */
    boolean saveMCart(MCart mCart);

    /**
     * 编辑购物车
     *
     * @param mCart
     * @return
     */
    boolean editMCart(MCart mCart);

    /**
     * 批量删除购物车信息
     * @param ids
     * @return
     */
    boolean batchRemoveMCart(List<String> ids);
}
