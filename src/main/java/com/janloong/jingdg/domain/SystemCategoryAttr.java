package com.janloong.jingdg.domain;

import java.io.Serializable;

/**
 * @author Janloong
 * @create 2017-07-18 下午8:03
 **/
public class SystemCategoryAttr implements Serializable {
    private static final long serialVersionUID = 1l;

    private String attrId;
    private Long categoryAttrId;
    private Integer attrIndexId;
    private String attName;
    private Integer inputType;
    private Long categoryId;
    private Integer attributeType;
    private String featuresAll;
    //private Set<Feature> attrFeatures;
    //private CategoryAttrGroup categoryAttrGroup;
    //private List<CategoryAttrValue> attrValueList;


    public String getAttrId() {
        return attrId;
    }

    public void setAttrId(String attrId) {
        this.attrId = attrId;
    }

    public Long getCategoryAttrId() {
        return categoryAttrId;
    }

    public void setCategoryAttrId(Long categoryAttrId) {
        this.categoryAttrId = categoryAttrId;
    }

    public Integer getAttrIndexId() {
        return attrIndexId;
    }

    public void setAttrIndexId(Integer attrIndexId) {
        this.attrIndexId = attrIndexId;
    }

    public String getAttName() {
        return attName;
    }

    public void setAttName(String attName) {
        this.attName = attName;
    }

    public Integer getInputType() {
        return inputType;
    }

    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(Integer attributeType) {
        this.attributeType = attributeType;
    }

    public String getFeaturesAll() {
        return featuresAll;
    }

    public void setFeaturesAll(String featuresAll) {
        this.featuresAll = featuresAll;
    }

    @Override
    public String toString() {
        return "SystemCategoryAttr{" +
                "attrId='" + attrId + '\'' +
                ", categoryAttrId=" + categoryAttrId +
                ", attrIndexId=" + attrIndexId +
                ", attName='" + attName + '\'' +
                ", inputType=" + inputType +
                ", categoryId=" + categoryId +
                ", attributeType=" + attributeType +
                ", featuresAll='" + featuresAll + '\'' +
                '}';
    }
}
