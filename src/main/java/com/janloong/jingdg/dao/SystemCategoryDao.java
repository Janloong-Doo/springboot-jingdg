package com.janloong.jingdg.dao;

import com.janloong.jingdg.domain.SystemCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SystemCategoryDao {
    int insert(@Param("pojo") SystemCategory pojo);

    int insertSelective(@Param("pojo") SystemCategory pojo);

    int insertList(@Param("pojos") List<SystemCategory> pojo);

    int update(@Param("pojo") SystemCategory pojo);

    List<SystemCategory> selectAll();

    List<SystemCategory> getIdByCategortLev(@Param("lev") Integer lev);
}
