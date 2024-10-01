package com.yupi.project.model.dto.goods;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yupi.project.model.entity.User;
import com.yupi.project.model.vo.UserVO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 查看商品详细信息响应类
 * @TableName goods
 */
@Data
public class goodsGetResponse implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 商品标题
     */
    private String goodsTitle;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 商品图片(图片可能会有多个)
     */
    private List<String> images;

    /**
     * 商品标签
     */
    private String tags;

    /**
     * 价格
     */
    private Double prices;

    /**
     * 商家的id
     */
    private UserVO user;


    private static final long serialVersionUID = 1L;
}