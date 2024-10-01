package com.yupi.project.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

public class GoodVO {
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
         * 商品图片
         */
        private String images;

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
        private Integer sellerId;

        /**
         * 商品剩余的数量
         */
        private Long num;

        /**
         * 创建时间
         */
        private Date createTime;

        /**
         * 更新时间
         */
        private Date updateTime;

        private static final long serialVersionUID = 1L;
}
