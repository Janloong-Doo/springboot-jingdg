package com.janloong.jingdg.dao;

import com.janloong.jingdg.domain.SystemCategoryAttr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SystemCategoryAttrDao {
    int insert(@Param("pojo") SystemCategoryAttr pojo);

    int insertSelective(@Param("pojo") SystemCategoryAttr pojo);

    int insertList(@Param("pojos") List<SystemCategoryAttr> pojo);

    int update(@Param("pojo") SystemCategoryAttr pojo);

    List<SystemCategoryAttr> selectAll();
}
