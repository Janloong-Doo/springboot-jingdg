package com.janloong.jingdg.controller.utils;

import com.jd.open.api.sdk.domain.list.CategoryAttrReadService.CategoryAttrGroup;
import com.jd.open.api.sdk.domain.list.CategoryAttrReadService.CategoryAttrValue;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author Janloong
 * @create 2017-07-19 上午11:40
 **/
public class CategoryAttr implements Serializable {
    private Long categoryAttrId;
    private Long categoryId;
    private String attName;
    private Integer attrIndexId;
    private Integer inputType;
    private Integer attributeType;
    private Set<Feature> attrFeatures;
    private CategoryAttrGroup categoryAttrGroup;
    private List<CategoryAttrValue> attrValueList;

    public CategoryAttr() {
    }

    @JsonProperty("categoryAttrId")
    public void setCategoryAttrId(Long categoryAttrId) {
        this.categoryAttrId = categoryAttrId;
    }

    @JsonProperty("categoryAttrId")
    public Long getCategoryAttrId() {
        return this.categoryAttrId;
    }

    @JsonProperty("categoryId")
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @JsonProperty("categoryId")
    public Long getCategoryId() {
        return this.categoryId;
    }

    @JsonProperty("attName")
    public void setAttName(String attName) {
        this.attName = attName;
    }

    @JsonProperty("attName")
    public String getAttName() {
        return this.attName;
    }

    @JsonProperty("attrValueIndexId")
    public void setAttrIndexId(Integer attrIndexId) {
        this.attrIndexId = attrIndexId;
    }

    @JsonProperty("attrValueIndexId")
    public Integer getAttrIndexId() {
        return this.attrIndexId;
    }

    @JsonProperty("inputType")
    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    @JsonProperty("inputType")
    public Integer getInputType() {
        return this.inputType;
    }

    @JsonProperty("attributeType")
    public void setAttributeType(Integer attributeType) {
        this.attributeType = attributeType;
    }

    @JsonProperty("attributeType")
    public Integer getAttributeType() {
        return this.attributeType;
    }

    @JsonProperty("attrValueFeatures")
    public void setAttrFeatures(Set<Feature> attrFeatures) {
        this.attrFeatures = attrFeatures;
    }

    @JsonProperty("attrValueFeatures")
    public Set<Feature> getAttrFeatures() {
        return this.attrFeatures;
    }

    @JsonProperty("categoryAttrGroup")
    public void setCategoryAttrGroup(CategoryAttrGroup categoryAttrGroup) {
        this.categoryAttrGroup = categoryAttrGroup;
    }

    @JsonProperty("categoryAttrGroup")
    public CategoryAttrGroup getCategoryAttrGroup() {
        return this.categoryAttrGroup;
    }

    @JsonProperty("attrValueList")
    public void setAttrValueList(List<CategoryAttrValue> attrValueList) {
        this.attrValueList = attrValueList;
    }

    @JsonProperty("attrValueList")
    public List<CategoryAttrValue> getAttrValueList() {
        return this.attrValueList;
    }
}

