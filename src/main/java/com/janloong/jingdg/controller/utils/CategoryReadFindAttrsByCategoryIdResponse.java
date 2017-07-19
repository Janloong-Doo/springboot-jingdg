package com.janloong.jingdg.controller.utils;


import com.jd.open.api.sdk.response.AbstractResponse;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * @author Janloong
 * @create 2017-07-19 上午11:34
 **/
public class CategoryReadFindAttrsByCategoryIdResponse extends AbstractResponse {
    private List<CategoryAttr> categoryAttrs;

    public CategoryReadFindAttrsByCategoryIdResponse() {
    }

    @JsonProperty("categoryAttrs")
    public void setCategoryAttrs(List<CategoryAttr> categoryAttrs) {
        this.categoryAttrs = categoryAttrs;
    }

    @JsonProperty("categoryAttrs")
    public List<CategoryAttr> getCategoryAttrs() {
        return this.categoryAttrs;
    }
}

