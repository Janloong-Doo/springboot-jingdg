package com.janloong.jingdg.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.janloong.jingdg.controller.jingdg.JdMethod;
import com.janloong.jingdg.controller.utils.CategoryAttr;
import com.janloong.jingdg.controller.utils.Feature;
import com.janloong.jingdg.dao.SystemCategoryAttrDao;
import com.janloong.jingdg.domain.SystemCategoryAttr;
import com.janloong.jingdg.utils.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SystemCategoryAttrService {
    private static final Logger logger = LoggerFactory.getLogger(SystemCategoryAttrService.class);


    @Resource
    private SystemCategoryAttrDao systemCategoryAttrDao;

    public int insert(SystemCategoryAttr pojo) {
        return systemCategoryAttrDao.insert(pojo);
    }

    public int insertSelective(SystemCategoryAttr pojo) {
        return systemCategoryAttrDao.insertSelective(pojo);
    }

    public int insertList(List<SystemCategoryAttr> pojos) {
        return systemCategoryAttrDao.insertList(pojos);
    }

    public int update(SystemCategoryAttr pojo) {
        return systemCategoryAttrDao.update(pojo);
    }

    /**
     * des: 插入类目属性列表
     *
     * @author Janloong
     * @create 17-7-19 上午11:14
     **/
    public int insertSystemCatergoryAttrList(JSONObject object, JdMethod method) {
        List<SystemCategoryAttr> categoryList = new ArrayList<>();
        try {
            JSONArray result = object.getJSONArray("result");
            if (result.size() < 1) {
                return 1;
            }
            List<CategoryAttr> categories = JSON.parseArray(result.toString(), CategoryAttr.class);

            //Stream<Object> stream = result.stream();
            //stream.map(Category.class::cast)
            categories.forEach((k) -> {
                SystemCategoryAttr systemCategoryAttr = new SystemCategoryAttr();
                systemCategoryAttr.setAttrId(UUIDUtil.getUUID());
                systemCategoryAttr.setAttName(k.getAttName());
                systemCategoryAttr.setAttributeType(k.getAttributeType());
                systemCategoryAttr.setAttrIndexId(k.getAttrIndexId());
                systemCategoryAttr.setCategoryAttrId(k.getCategoryAttrId());
                systemCategoryAttr.setCategoryId(k.getCategoryId());
                systemCategoryAttr.setInputType(k.getInputType());

                //拼接feature
                StringBuilder builder = new StringBuilder();
                Set<Feature> features = k.getAttrFeatures();
                features.forEach((v) -> {
                    builder.append(v.getAttrValueFeatureKey());
                    builder.append(":");
                    builder.append(v.getAttrValueFeatureValue());
                    if (!StringUtils.isEmpty(v.getAttrValueFeatureCn())) {
                        builder.append(":");
                        builder.append("cn-");
                        builder.append(v.getAttrValueFeatureCn());
                    }
                    builder.append(",");
                });
                systemCategoryAttr.setFeaturesAll(builder.toString().substring(0, builder.length() - 1));
                categoryList.add(systemCategoryAttr);
            });
            categoryList.forEach(systemCategoryAttr -> {
                logger.info("\n遍历类目属性列表-SystemCategoryAttrService-insertSystemCatergoryAttrList：" + "\n"
                        + "systemCategoryAttr:" + systemCategoryAttr.toString() + "\n"
                );
            });
            //return 1;
            return systemCategoryAttrDao.insertList(categoryList);
        } catch (Exception e) {
            logger.error("插入错误:" + categoryList.size() + "----" + e.getMessage());
            e.printStackTrace();
        }
        return -1;
    }

    public List<SystemCategoryAttr> getCategoryAttrList() {
        return systemCategoryAttrDao.selectAll();
    }
}
