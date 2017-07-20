package com.janloong.jingdg.controller.utils;

import com.jd.open.api.sdk.internal.util.JsonUtil;
import com.jd.open.api.sdk.request.AbstractRequest;
import com.jd.open.api.sdk.request.JdRequest;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Janloong
 * @create 2017-07-19 下午6:52
 **/
public class CategoryReadFindValuesByAttrIdRequest extends AbstractRequest implements JdRequest<CategoryReadFindValuesByAttrIdResponse> {
    private Long categoryAttrId;
    private String field;

    public CategoryReadFindValuesByAttrIdRequest() {
    }

    public void setCategoryAttrId(Long categoryAttrId) {
        this.categoryAttrId = categoryAttrId;
    }

    public Long getCategoryAttrId() {
        return this.categoryAttrId;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getField() {
        return this.field;
    }

    public String getApiMethod() {
        return "jingdong.category.read.findValuesByAttrId";
    }

    public String getAppJsonParams() throws IOException {
        Map<String, Object> pmap = new TreeMap();
        pmap.put("categoryAttrId", this.categoryAttrId);
        pmap.put("field", this.field);
        return JsonUtil.toJson(pmap);
    }

    public Class<CategoryReadFindValuesByAttrIdResponse> getResponseClass() {
        return CategoryReadFindValuesByAttrIdResponse.class;
    }
}
