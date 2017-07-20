package com.janloong.jingdg.controller.utils.feature;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

/**
 * @author Janloong
 * @create 2017-07-19 下午6:56
 **/
public class Feature implements Serializable {

    private String featureKey;
    private String value;

    public Feature() {
    }

    @JsonProperty("featureKey")
    public void setFeatureKey(String featureKey) {
        this.featureKey = featureKey;
    }

    @JsonProperty("featureKey")
    public String getFeatureKey() {
        return this.featureKey;
    }

    @JsonProperty("value")
    public void setValue(String featureValue) {
        this.value = featureValue;
    }

    @JsonProperty("value")
    public String getValue() {
        return this.value;
    }
}