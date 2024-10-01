package com.yupi.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.common.ResultUtils;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.model.dto.goods.goodsGetResponse;
import com.yupi.project.model.entity.User;
import com.yupi.project.model.entity.goods;
import com.yupi.project.mapper.goodsMapper;
import com.yupi.project.model.vo.UserVO;
import com.yupi.project.service.UserService;
import com.yupi.project.service.goodsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
* @author Administrator
* @description 针对表【goods】的数据库操作Service实现
* @createDate 2024-09-23 18:10:25
*/
@Service
public class goodsServiceImpl extends ServiceImpl<goodsMapper, goods>
    implements goodsService{


    @Resource
    private UserService userService;


    @Override
    public goodsGetResponse GetGoodInfoById(Long id) {
        goods goods = this.getById(id);
        if(goods==null){
            new BusinessException(ErrorCode.PARAMS_ERROR,"商品不存在");
        }

        Long sellerId = Long.valueOf(goods.getSellerId());//获取卖家的id
        //根据商家的id来获取商家的信息
        User user=userService.getById(sellerId);
        UserVO userVO=new UserVO();
        //将user的值封装到userVO中，避免不必要的字段返回
        BeanUtils.copyProperties(user,userVO);
        goodsGetResponse goodsGetResponse=new goodsGetResponse();
        //将值封装到商品响应类中
        goodsGetResponse.setUser(userVO);
        goodsGetResponse.setId(goods.getId());
        goodsGetResponse.setGoodsTitle(goods.getGoodsTitle());
        goodsGetResponse.setDescription(goods.getDescription());
        //设置商品图片
        List<String> imageList=new ArrayList<>();
        //todo 这里假设只有一张图片，可优化为多张图片
        imageList.add(goods.getImages());

        goodsGetResponse.setImages(imageList);
        goodsGetResponse.setTags(goods.getTags());
        goodsGetResponse.setPrices(goods.getPrices());
        return goodsGetResponse;
    }
}




