package com.janloong.jingdg.controller.utils;


import com.jd.open.api.sdk.response.AbstractResponse;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * @author Janloong
 * @create 2017-07-19 下午6:53
 **/
public class CategoryReadFindValuesByAttrIdResponse extends AbstractResponse {
    private List<CategoryAttrValue> categoryAttrValues;

    public CategoryReadFindValuesByAttrIdResponse() {
    }

    @JsonProperty("categoryAttrValues")
    public void setCategoryAttrValues(List<CategoryAttrValue> categoryAttrValues) {
        this.categoryAttrValues = categoryAttrValues;
    }

    @JsonProperty("categoryAttrValues")
    public List<CategoryAttrValue> getCategoryAttrValues() {
        return this.categoryAttrValues;
    }
}