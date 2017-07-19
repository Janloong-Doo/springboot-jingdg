package com.janloong.jingdg.dao;

import com.janloong.jingdg.domain.SystemCategoryAttrValues;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SystemCategoryAttrValuesDao {
    int insert(@Param("pojo") SystemCategoryAttrValues pojo);

    int insertSelective(@Param("pojo") SystemCategoryAttrValues pojo);

    int insertList(@Param("pojos") List<SystemCategoryAttrValues> pojo);

    int update(@Param("pojo") SystemCategoryAttrValues pojo);
}
