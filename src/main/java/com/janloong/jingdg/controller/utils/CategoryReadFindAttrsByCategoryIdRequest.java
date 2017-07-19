package com.janloong.jingdg.controller.utils;

import com.jd.open.api.sdk.internal.util.JsonUtil;
import com.jd.open.api.sdk.request.AbstractRequest;
import com.jd.open.api.sdk.request.JdRequest;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * des ：  京东domain重写 （垃圾京东 jsonPro 都是错误的）
 * @author Janloong
 * @create 2017-07-19 上午11:31
 **/
public class CategoryReadFindAttrsByCategoryIdRequest extends AbstractRequest implements JdRequest<CategoryReadFindAttrsByCategoryIdResponse> {
    private Long cid;
    private Integer attributeType;
    private String field;

    public CategoryReadFindAttrsByCategoryIdRequest() {
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getCid() {
        return this.cid;
    }

    public void setAttributeType(Integer attributeType) {
        this.attributeType = attributeType;
    }

    public Integer getAttributeType() {
        return this.attributeType;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getField() {
        return this.field;
    }

    public String getApiMethod() {
        return "jingdong.category.read.findAttrsByCategoryId";
    }

    public String getAppJsonParams() throws IOException {
        Map<String, Object> pmap = new TreeMap();
        pmap.put("cid", this.cid);
        pmap.put("attributeType", this.attributeType);
        pmap.put("field", this.field);
        return JsonUtil.toJson(pmap);
    }

    public Class<CategoryReadFindAttrsByCategoryIdResponse> getResponseClass() {
        return CategoryReadFindAttrsByCategoryIdResponse.class;
    }
}

