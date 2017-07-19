package com.janloong.jingdg.domain;

import java.io.Serializable;

/**
 * @author Janloong
 * @create 2017-07-19 下午2:23
 **/
public class SystemCategoryAttrValues implements Serializable {
    private static final long serialVersionUID = 1l;

    private String valueId;
    private Long attributeId;
    private Long categoryId;
    private String featuresAll;
    private Long id;
    private Integer indexId;
    private String value;

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    public Long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getFeaturesAll() {
        return featuresAll;
    }

    public void setFeaturesAll(String featuresAll) {
        this.featuresAll = featuresAll;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIndexId() {
        return indexId;
    }

    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SystemCategoryAttrValues{" +
                "valueId='" + valueId + '\'' +
                ", attributeId=" + attributeId +
                ", categoryId=" + categoryId +
                ", featuresAll='" + featuresAll + '\'' +
                ", id=" + id +
                ", indexId=" + indexId +
                ", value='" + value + '\'' +
                '}';
    }
}
