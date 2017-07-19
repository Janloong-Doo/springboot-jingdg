package com.janloong.jingdg.controller.utils;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * @author Janloong
 * @create 2017-07-19 下午12:01
 **/
public class Feature implements Serializable {
    private String attrValueFeatureCn;
    private String attrValueFeatureKey;
    private String attrValueFeatureValue;

    public Feature() {
    }

    @JsonProperty("attrValueFeatureCn")
    public void setAttrValueFeatureCn(String attrFeatureCn) {
        this.attrValueFeatureCn = attrFeatureCn;
    }

    @JsonProperty("attrValueFeatureCn")
    public String getAttrValueFeatureCn() {
        return this.attrValueFeatureCn;
    }

    @JsonProperty("attrValueFeatureKey")
    public void setAttrValueFeatureKey(String attrFeatureKey) {
        this.attrValueFeatureKey = attrFeatureKey;
    }

    @JsonProperty("attrValueFeatureKey")
    public String getAttrValueFeatureKey() {
        return this.attrValueFeatureKey;
    }

    @JsonProperty("attrValueFeatureValue")
    public void setAttrValueFeatureValue(String attrFeatureValue) {
        this.attrValueFeatureValue = attrFeatureValue;
    }

    @JsonProperty("attrValueFeatureValue")
    public String getAttrValueFeatureValue() {
        return this.attrValueFeatureValue;
    }
}