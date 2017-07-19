package com.janloong.jingdg.controller.jingdg;

import com.alibaba.fastjson.JSONObject;
import com.janloong.jingdg.controller.utils.CategoryReadFindAttrsByCategoryIdRequest;
import com.janloong.jingdg.controller.utils.CategoryReadFindAttrsByCategoryIdResponse;
import com.janloong.jingdg.service.SystemCategoryService;
import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.domain.list.CategoryAttrReadService.CategoryAttr;
import com.jd.open.api.sdk.domain.list.CategoryAttrReadService.CategoryAttrJos;
import com.jd.open.api.sdk.domain.list.CategoryAttrValueReadService.CategoryAttrValue;
import com.jd.open.api.sdk.domain.list.CategoryAttrValueReadService.CategoryAttrValueJos;
import com.jd.open.api.sdk.domain.list.CategoryReadService.Category;
import com.jd.open.api.sdk.request.category.CategorySearchRequest;
import com.jd.open.api.sdk.request.list.*;
import com.jd.open.api.sdk.request.mall.SearchWareRequest;
import com.jd.open.api.sdk.response.category.CategorySearchResponse;
import com.jd.open.api.sdk.response.list.*;
import com.jd.open.api.sdk.response.mall.SearchWareResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sword.lang.http.HttpsUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Janloong
 * @create 2017-07-12 下午3:26
 **/
public class JdRequestManager {
    private static final Logger logger = LoggerFactory.getLogger(JdRequestManager.class);

    @Resource
    private SystemCategoryService systemCategoryService;

    private String baseUrl = "https://api.jd.com/routerjson";
    //private String baseUrl = "https://jos.jd.com/";
    //private String baseUrl = "https://gw.api.360buy.com/routerjson";
    //private String baseUrl = "https://jos.360buy.com";
    //无线应用
    public static String appKey = "B0942000071618A57E6FEB7E2A9E6C30";
    public static String appSecret = "b53fbfb7b1f14005a9fea2050616d264";
    public static String accessToken = "fce436e5-d001-4317-94a8-d6e9b5393e11";

    //通用应用
    //public  static String appKey = "033A8DB7E2B7CFB716EC616A71DEDEE4";
    //public static String appSecret = "35581cdc43274148964d4067fc76b0c0";
    //public static String accessToken = "fce436e5-d001-4317-94a8-d6e9b5393e11";

    private String paramsName = "360buy_param_json";


    /**
     * des: 公共请求参数
     *
     * @author Janloong
     * @create 17-7-12 下午3:45
     **/
    private JSONObject getCommonParam() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("app_key", appKey);
        //jsonObject.put("format", "json");
        jsonObject.put("v", "2.0");
        jsonObject.put("access_token", accessToken);
        Date date = new Date();
        //LocalDateTime localDateTime = LocalDateTime.now();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = format.format(date);
        jsonObject.put("timestamp", date1);
        return jsonObject;
    }

    /**
     * des: 京东借口方法调用
     * <p>
     * https://api.jd.com/routerjson
     * ?v=2.0
     * &method=360buy.warecats.get
     * &app_key=B0942000071618A57E6FEB7E2A9E6C30
     * &access_token=fce436e5-d001-4317-94a8-d6e9b5393e11
     * &360buy_param_json={"fields":""}
     * &timestamp=2017-07-12 15:24:40
     * &sign=740B222A77BEBCA848456184F765DA66
     *
     * @author Janloong
     * @create 17-7-12 下午3:41
     **/
    public String getResult(JSONObject object, JdMethod jdMethod) {
        //应用参数字典排序
        Map map = object;
        Map<String, String> sortMap = JdUtils.sortMap(map);
        JSONObject jsonObject = new JSONObject();
        jsonObject.putAll(sortMap);
        //应用参数拼接
        String method = jdMethod.getMethod();
        logger.info("\n1-JdRequestManager-getResult：" + "\n" +
                "object:" + object.toJSONString() + "\n" +
                "method:" + method + "\n"
        );
        //JdMethod leimu = JdMethod.LEIMU;
        //String method = leimu.getMethod();
        //String url = baseUrl;
        JSONObject jsonParams = getCommonParam();
        jsonParams.put(paramsName, jsonObject);
        jsonParams.put("method", method);
        logger.info("--------------1---------------");
        //系统参数字典排序
        Map params = jsonParams;
        logger.info("--------------2---------------");
        Map jsonMap = JdUtils.sortMap(params);
        logger.info("--------------3---------------");

        //参数拼接加密
        String sign = JdUtils.signParams(jsonMap, appSecret);
        logger.info("--------------4---------------");
        //系统参数增加
        //jsonParams.put("sign", sign);
        jsonParams.put("sign", sign);
        logger.info("--------------5---------------");
        logger.info("\njd请求参数拼接-JdRequestManager-getResult：" + "\n" +
                "jsonParams:" + jsonParams.toJSONString() + "\n");
        //String url = baseUrl;
        //String url = baseUrl+"?";
        //
        //StringBuilder builder = new StringBuilder();
        //jsonMap.forEach((k,v) ->{
        //
        //    builder.append(k+"=");
        //    builder.append(v+"&");
        //});
        //String substring = builder.substring(0, builder.length() - 1);
        ////Map map1 = jsonParams;
        ////map1.forEach();
        //url = url + substring;
        //
        ////String encode = URLEncoder.encode(url);
        //  logger.info("\n请求接口的url-JdRequestManager-getResult："+"\n"+
        //                  "url:"+url+"\n"
        //                  );
        //String result = HttpUtils.post(url);

        String result = HttpsUtils.post(baseUrl, jsonParams.toJSONString());
        return result;
    }

/*--------------------------------------分界线----------------------------------------------*/

    /**
     * des: 获取类目属性
     *
     * @author Janloong
     * @create 17-7-13 下午4:33
     **/
    public String getRequestBySDK(CategoryReadFindAttrByIdRequest request) {
        String result = null;
        try {
            JdClient jdClient = new DefaultJdClient(baseUrl, accessToken, appKey, appSecret);
            CategoryReadFindAttrByIdResponse response = jdClient.execute(request);
            logger.info("\nsdk请求-JdRequestManager-getRequestBySDK：" + "\n" +
                    "response:" + response.toString() + "\n"
            );
            //String code = response.getCode();
            //String enDesc = response.getEnDesc();
            //String msg = response.getMsg();
            //String zhDesc = response.getZhDesc();
            //String url = response.getUrl();
            //CategoryAttr categoryAttr = response.getCategoryAttr();
            //String attName = categoryAttr.getAttName();
            //Integer inputType = categoryAttr.getInputType();
            //StringBuilder builder = new StringBuilder();
            //result = builder.append(code)
            //        .append(enDesc)
            //        .append(msg)
            //        .append(zhDesc)
            //        .append(url)
            //        .append(attName)
            //        .append(inputType).toString();
            result = JSONObject.toJSONString(response);
        } catch (JdException e) {
            e.getMessage();
        }
        return result;
    }

    public JSONObject getRequestByJdSdk(String data, String jdMethod) {
        JdClient jdClient = new DefaultJdClient(baseUrl, accessToken, appKey, appSecret);
        //String result = null;
        JSONObject result = new JSONObject();
        try {
            JdMethod method = JdMethod.valueOf(jdMethod);
            switch (method) {
                case FINDATTRBYID:
                    CategoryReadFindAttrByIdRequest findAttrByIdRequest = JSONObject.parseObject(data, CategoryReadFindAttrByIdRequest.class);
                    CategoryReadFindAttrByIdResponse execute = jdClient.execute(findAttrByIdRequest);
                    //result = JSONObject.toJSONString(execute);
                    CategoryAttr categoryAttr = execute.getCategoryAttr();
                    result.put("result", categoryAttr);

                    break;
                case FINDATTRBYIDJOS:
                    CategoryReadFindAttrByIdJosRequest object = JSONObject.parseObject(data, CategoryReadFindAttrByIdJosRequest.class);
                    CategoryReadFindAttrByIdJosResponse execute1 = jdClient.execute(object);
                    //result = JSONObject.toJSONString(execute1);
                    CategoryAttrJos categoryAttr1 = execute1.getCategoryAttr();
                    result.put("result", categoryAttr1);

                    break;
                case WARE:

                    SearchWareRequest object10 = JSONObject.parseObject(data, SearchWareRequest.class);
                    SearchWareResponse execute11 = jdClient.execute(object10);
                    //result = JSONObject.toJSONString(execute11);
                    result.put("result", execute11);

                    break;
                case FINDVALUESBYID:
                    CategoryReadFindValuesByIdRequest object4 = JSONObject.parseObject(data, CategoryReadFindValuesByIdRequest.class);
                    CategoryReadFindValuesByIdResponse execute5 = jdClient.execute(object4);
                    //result = JSONObject.toJSONString(execute5);
                    CategoryAttrValue categoryAttrValue = execute5.getCategoryAttrValue();
                    result.put("result", categoryAttrValue);

                    break;
                case FINDVALUESBYIDJOS:
                    CategoryReadFindValuesByIdJosRequest object6 = JSONObject.parseObject(data, CategoryReadFindValuesByIdJosRequest.class);
                    CategoryReadFindValuesByIdJosResponse execute7 = jdClient.execute(object6);
                    //result = JSONObject.toJSONString(execute7);
                    CategoryAttrValueJos categoryAttrValue1 = execute7.getCategoryAttrValue();
                    result.put("result", categoryAttrValue1);

                    break;
                case GET:
                    CategorySearchRequest object1 = JSONObject.parseObject(data, CategorySearchRequest.class);
                    CategorySearchResponse execute2 = jdClient.execute(object1);
                    //result = JSONObject.toJSONString(execute2);
                    result.put("result", execute2);

                    break;
                case FINDATTRSBYCATEGORYIDJOS:
                    CategoryReadFindAttrsByCategoryIdJosRequest object7 = JSONObject.parseObject(data, CategoryReadFindAttrsByCategoryIdJosRequest.class);
                    CategoryReadFindAttrsByCategoryIdJosResponse execute8 = jdClient.execute(object7);
                    //result = JSONObject.toJSONString(execute8);
                    List<CategoryAttrJos> categoryAttrs1 = execute8.getCategoryAttrs();
                    result.put("result", categoryAttrs1);

                    break;
                case FINDVALUESBYATTRIDJOS:
                    CategoryReadFindValuesByAttrIdJosRequest object8 = JSONObject.parseObject(data, CategoryReadFindValuesByAttrIdJosRequest.class);
                    CategoryReadFindValuesByAttrIdJosResponse execute9 = jdClient.execute(object8);
                    //result = JSONObject.toJSONString(execute9);
                    List<CategoryAttrValueJos> categoryAttrValues1 = execute9.getCategoryAttrValues();
                    result.put("result", categoryAttrValues1);

                    break;
                case FINDVALUESBYATTRID:
                    CategoryReadFindValuesByAttrIdRequest object2 = JSONObject.parseObject(data, CategoryReadFindValuesByAttrIdRequest.class);
                    CategoryReadFindValuesByAttrIdResponse execute3 = jdClient.execute(object2);
                    //result = JSONObject.toJSONString(execute3);
                    List<CategoryAttrValue> categoryAttrValues = execute3.getCategoryAttrValues();
                    result.put("result", categoryAttrValues);
                    break;
                case FINDBYPID:
                    CategoryReadFindByPIdRequest object5 = JSONObject.parseObject(data, CategoryReadFindByPIdRequest.class);
                    CategoryReadFindByPIdResponse execute6 = jdClient.execute(object5);
                    List<Category> categories = execute6.getCategories();
                    //JSONObject result = new JSONObject();
                    result.put("result", categories);
                    break;
                case FINDBYID:
                    CategoryReadFindByIdRequest object9 = JSONObject.parseObject(data, CategoryReadFindByIdRequest.class);
                    CategoryReadFindByIdResponse execute10 = jdClient.execute(object9);
                    Category category = execute10.getCategory();
                    //JSONObject result = new JSONObject();
                    result.put("result", category);
                    break;
                case FINDATTRSBYCATEGORYID:
                    CategoryReadFindAttrsByCategoryIdRequest object3 = JSONObject.parseObject(data,
                            CategoryReadFindAttrsByCategoryIdRequest.class);
                    CategoryReadFindAttrsByCategoryIdResponse execute4 = jdClient.execute(object3);
                    //result = JSONObject.toJSONString(execute4);
                    List<com.janloong.jingdg.controller.utils.CategoryAttr> categoryAttrs = execute4.getCategoryAttrs();
                    //JSONObject result = new JSONObject();
                    result.put("result", categoryAttrs);
                    break;
                default:
                    break;
            }
        } catch (JdException e) {
            e.printStackTrace();
        }
        return result;
    }
}
