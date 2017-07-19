package com.janloong.jingdg.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.janloong.jingdg.controller.jingdg.JdMethod;
import com.janloong.jingdg.dao.SystemCategoryAttrValuesDao;
import com.janloong.jingdg.domain.SystemCategoryAttrValues;
import com.janloong.jingdg.utils.UUIDUtil;
import com.jd.open.api.sdk.domain.list.CategoryAttrValueReadService.CategoryAttrValue;
import com.jd.open.api.sdk.domain.list.CategoryAttrValueReadService.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SystemCategoryAttrValuesService {
    private static final Logger logger = LoggerFactory.getLogger(SystemCategoryAttrValuesService.class);

    @Resource
    private SystemCategoryAttrValuesDao systemCategoryAttrValuesDao;

    public int insert(SystemCategoryAttrValues pojo) {
        return systemCategoryAttrValuesDao.insert(pojo);
    }

    public int insertSelective(SystemCategoryAttrValues pojo) {
        return systemCategoryAttrValuesDao.insertSelective(pojo);
    }

    public int insertList(List<SystemCategoryAttrValues> pojos) {
        return systemCategoryAttrValuesDao.insertList(pojos);
    }

    public int update(SystemCategoryAttrValues pojo) {
        return systemCategoryAttrValuesDao.update(pojo);
    }

    public Integer insertSystemCatergoryAttrValues(JSONObject object, JdMethod method) {
        List<SystemCategoryAttrValues> categoryAttrValuesList = new ArrayList<>();
        try {
            JSONArray result = object.getJSONArray("result");
            List<CategoryAttrValue> categories = JSON.parseArray(result.toString(), CategoryAttrValue.class);

            //Stream<Object> stream = result.stream();
            //stream.map(Category.class::cast)
            categories.forEach((k) -> {
                SystemCategoryAttrValues systemCategoryAttrValues = new SystemCategoryAttrValues();
                systemCategoryAttrValues.setValueId(UUIDUtil.getUUID());
                systemCategoryAttrValues.setAttributeId(k.getAttributeId());
                systemCategoryAttrValues.setValue(k.getValue());
                systemCategoryAttrValues.setCategoryId(k.getCategoryId());
                systemCategoryAttrValues.setId(k.getId());
                systemCategoryAttrValues.setIndexId(k.getIndexId());

                //拼接feature
                StringBuilder builder = new StringBuilder();
                Set<Feature> features = k.getFeatures();
                features.forEach((v) -> {
                    builder.append(v.getFeatureKey());
                    builder.append(":");
                    builder.append(v.getFeatureValue());
                    if (!StringUtils.isEmpty(v.getFeatureCn())) {
                        builder.append(":");
                        builder.append(v.getFeatureCn());
                    }
                    builder.append(":");
                });
                systemCategoryAttrValues.setFeaturesAll(builder.toString().substring(0, builder.length() - 1));
                categoryAttrValuesList.add(systemCategoryAttrValues);
            });
            categoryAttrValuesList.forEach(systemCategoryAttr -> {
                logger.info("\n遍历类目属性列表-SystemCategoryAttrValuesService-insertSystemCatergoryAttrValues：" + "\n"
                        + "categoryAttrValuesList:" + systemCategoryAttr.toString() + "\n"
                );
            });
            //return 1;
            return systemCategoryAttrValuesDao.insertList(categoryAttrValuesList);
        } catch (Exception e) {
            logger.error("插入错误:", categoryAttrValuesList.size(), e.getMessage());
        }
        return -1;
    }
}
