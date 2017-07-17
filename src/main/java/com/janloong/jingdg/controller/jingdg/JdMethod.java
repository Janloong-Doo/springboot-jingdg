package com.janloong.jingdg.controller.jingdg;

public enum JdMethod {
    //获取类目信息
    FINDATTRBYID("jingdong.category.read.findAttrById"), //获取类目属性
    FINDVALUESBYATTRID("jingdong.category.read.findValuesByAttrId"),//通过类目属性ID获取属性值列表
    GET("360buy.warecats.get"), //获取商家类目信息
    FINDATTRSBYCATEGORYID("jingdong.category.read.findAttrsByCategoryId"), //获取商家类目信息
    FINDVALUESBYID("jingdong.category.read.findValuesById"),// 获取类目属性值
    FINDBYID("jingdong.category.read.findById"),// 获取单个类目信息
    FINDBYPID("jingdong.category.read.findByPId"),// 查找子类目列表
    FINDVALUESBYIDJOS("jingdong.category.read.findValuesByIdJos"),// 获取类目属性值
    FINDATTRSBYCATEGORYIDJOS("jingdong.category.read.findAttrsByCategoryIdJos "),//获取类目属性列表
    FINDATTRBYIDJOS("jingdong.category.read.findAttrByIdJos"),//获取属性的可选值列表(过滤重复字段名)
    FINDVALUESBYATTRIDJOS("jingdong.category.read.findValuesByAttrIdJos")//通过类目属性ID获取属性值列表


    ,WARE("jingdong.search.ware") //商品搜索
    ;

    private String method;

    private JdMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
