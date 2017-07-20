package com.janloong.jingdg.controller.utils;

import org.codehaus.jackson.annotate.JsonProperty;
import com.janloong.jingdg.controller.utils.feature.Feature;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Janloong
 * @create 2017-07-19 下午6:54
 **/
public class CategoryAttrValue implements Serializable {
    private Long attributeId;
    private Long categoryId;
    private Set<Feature> features;
    private Long id;
    private Integer indexId;
    private String value;

    public CategoryAttrValue() {
    }

    @JsonProperty("attributeId")
    public void setAttributeId(Long attributeId) {
        this.attributeId = attributeId;
    }

    @JsonProperty("attributeId")
    public Long getAttributeId() {
        return this.attributeId;
    }

    @JsonProperty("categoryId")
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @JsonProperty("categoryId")
    public Long getCategoryId() {
        return this.categoryId;
    }

    @JsonProperty("features")
    public void setFeatures(Set<Feature> features) {
        this.features = features;
    }

    @JsonProperty("features")
    public Set<Feature> getFeatures() {
        return this.features;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("id")
    public Long getId() {
        return this.id;
    }

    @JsonProperty("indexId")
    public void setIndexId(Integer indexId) {
        this.indexId = indexId;
    }

    @JsonProperty("indexId")
    public Integer getIndexId() {
        return this.indexId;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("value")
    public String getValue() {
        return this.value;
    }
}
