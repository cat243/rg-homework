package com.yupi.project.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yupi.project.common.BaseResponse;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.common.ResultUtils;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.model.dto.goods.goodsGetResponse;
import com.yupi.project.model.entity.User;
import com.yupi.project.model.entity.goods;
import com.yupi.project.model.vo.GoodVO;
import com.yupi.project.model.vo.UserVO;
import com.yupi.project.service.UserService;
import com.yupi.project.service.goodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/goods")
@Slf4j
public class GoodsController {

    @Resource
    private goodsService  goodsService;


    /**
     * 查询所有商品的数据
     * @return
     */
    @GetMapping("/list")
    public BaseResponse<List<goods>>listAllGoods(){
        List<goods> goodsList = goodsService.list();
        if(goodsList==null){
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR,"商品列表为空号");
        }
        return ResultUtils.success(goodsList);
    }

    /**
     * 根据id来查看详细的商品信息
     * @param id
     * @return
     */
    @GetMapping("/GetGoodInfo")
    public BaseResponse<goodsGetResponse>GetGoodInfoById(Long id){
        //根据id获取商品
        if(id<0||id==null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"商品不存在");
        }
        goodsGetResponse goodsGetResponse=goodsService.GetGoodInfoById(id);
        if(goodsGetResponse==null){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR,"获取商品数据失败");
        }
        return ResultUtils.success(goodsGetResponse);
    }
}
