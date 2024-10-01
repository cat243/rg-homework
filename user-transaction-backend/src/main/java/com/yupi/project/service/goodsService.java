package com.yupi.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.project.model.dto.goods.goodsGetResponse;
import com.yupi.project.model.entity.goods;

/**
* @author Administrator
* @description 针对表【goods】的数据库操作Service
* @createDate 2024-09-23 18:10:25
*/
public interface goodsService extends IService<goods> {

    /**
     * 根据Id来获取商品的详细信息
     * @param id
     * @return
     */
    goodsGetResponse GetGoodInfoById(Long id);

}
