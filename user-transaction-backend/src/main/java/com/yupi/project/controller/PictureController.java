package com.yupi.project.controller;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.project.common.BaseResponse;

import com.yupi.project.common.ErrorCode;
import com.yupi.project.common.ResultUtils;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.model.entity.Picture;
import com.yupi.project.model.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 爬虫获取图片地址的接口(辅助)
 */
@RestController
@RequestMapping("/picture")
@Slf4j
public class PictureController {
    @GetMapping("/getByText")
    public BaseResponse<Page<Picture>> searchPicture(String searchText, long pageNum, long pageSize) {
        long current=(pageNum-1)*pageSize;
        String url = String.format("https://www.bing.com/images/search?q=%s&first=%s", searchText, current);
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据获取异常");
        }
        Elements elements = doc.select(".iuscp.isv");
        List<Picture> pictures=new ArrayList<>();
        for(Element element: elements){//遍历爬到的element元素
            // 取图片地址 (murl)
            String m = element.select(".iusc").get(0).attr("m");
            Map<String,Object> map= JSONUtil.toBean(m,Map.class);
            String murl=(String)map.get("murl");
            //取标题
            String title = element.select(".inflnk").get(0).attr("aria-label");
            Picture picture=new Picture();
            picture.setTitle(title);
            picture.setUrl(murl);
            pictures.add(picture);
            if (pictures.size()>=pageSize){
                break;
            }
        }
        Page<Picture>picturePage=new Page<>(pageNum,pageSize);
        picturePage.setRecords(pictures);//将数据存入
        return ResultUtils.success(picturePage);}
    }
