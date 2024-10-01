package com.yupi.project.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yupi.project.model.entity.goods;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
public class GoodServiceTest {
    @Resource
    private goodsService goodsService;


    @Test
    void listAllGodds(){
        //当list传入空值表示查询所有
        List<goods> goodsList = goodsService.list();
            for(goods goods:goodsList){
              System.out.println(goods);
          }
    }
}
