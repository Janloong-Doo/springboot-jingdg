package com.janloong.jingdg.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.janloong.jingdg.controller.jingdg.JdMethod;
import com.janloong.jingdg.dao.SystemCategoryDao;
import com.janloong.jingdg.domain.SystemCategory;
import com.janloong.jingdg.utils.UUIDUtil;
import com.jd.open.api.sdk.domain.list.CategoryReadService.Category;
import com.jd.open.api.sdk.domain.list.CategoryReadService.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SystemCategoryService {
    private static final Logger logger = LoggerFactory.getLogger(SystemCategoryService.class);

    @Resource
    private SystemCategoryDao systemCategoryDao;

    public int insert(SystemCategory pojo) {
        return systemCategoryDao.insert(pojo);
    }

    public int insertSelective(SystemCategory pojo) {
        return systemCategoryDao.insertSelective(pojo);
    }

    public int insertList(List<SystemCategory> pojos) {
        return systemCategoryDao.insertList(pojos);
    }

    public int update(SystemCategory pojo) {
        return systemCategoryDao.update(pojo);
    }

    public List<SystemCategory> selectAll() {
        return systemCategoryDao.selectAll();
    }

    public int insertListWithSystemCatergory(JSONObject object, JdMethod method) {
        List<SystemCategory> categoryList = new ArrayList<>();
        try {
            JSONArray result = object.getJSONArray("result");
            if (result.size() < 1) {
                return 1;
            }
            List<Category> categories = JSON.parseArray(result.toString(), Category.class);

            //Stream<Object> stream = result.stream();
            //stream.map(Category.class::cast)
            categories.forEach((k) -> {
                SystemCategory systemCategory = new SystemCategory();
                systemCategory.setCid(UUIDUtil.getUUID());
                systemCategory.setFid(k.getFid());
                systemCategory.setId(k.getId());
                systemCategory.setLev(k.getLev());
                systemCategory.setName(k.getName());
                systemCategory.setOrder(k.getOrder());

                //拼接feature
                StringBuilder builder = new StringBuilder();
                Set<Feature> features = k.getFeatures();
                features.forEach((v) -> {
                    builder.append(v.getFeatureKey());
                    builder.append(":");
                    builder.append(v.getFeatureValue());
                    if (!StringUtils.isEmpty(v.getFeatureCn())) {
                        builder.append(":");
                        builder.append("cn-");
                        builder.append(v.getFeatureCn());
                    }
                    builder.append(";");
                });
                systemCategory.setFeaturesAll(builder.toString().substring(0, builder.length() - 1));
                categoryList.add(systemCategory);
            });
            return systemCategoryDao.insertList(categoryList);
        } catch (Exception e) {
            logger.error("插入错误:" + categoryList.size() + "-----" + e.getMessage());
            e.printStackTrace();
        }
        return -1;
    }

    public List<SystemCategory> getIdByCategortLev(Integer lev) {

        List<SystemCategory> idByCategortLev = systemCategoryDao.getIdByCategortLev(lev);

        return idByCategortLev;
    }
}
