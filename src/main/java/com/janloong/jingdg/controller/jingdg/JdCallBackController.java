package com.janloong.jingdg.controller.jingdg;

import com.alibaba.fastjson.JSONObject;
import com.janloong.jingdg.domain.SystemCategoryAttr;
import com.janloong.jingdg.service.SystemCategoryAttrValuesService;
import com.janloong.jingdg.utils.ResponseResult;
import com.janloong.jingdg.utils.ReturnCode;
import com.janloong.jingdg.domain.SystemCategory;
import com.janloong.jingdg.service.SystemCategoryAttrService;
import com.janloong.jingdg.service.SystemCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.sword.lang.HttpUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * @author Janloong
 * @create 2017-07-12 上午9:36
 **/
@RestController
@RequestMapping("/jingdg")
public class JdCallBackController {
    private static final Logger logger = LoggerFactory.getLogger(JdCallBackController.class);

    @Resource
    private SystemCategoryService systemCategoryService;
    @Resource
    private SystemCategoryAttrService systemCategoryAttrService;
    @Resource
    private SystemCategoryAttrValuesService systemCategoryAttrValuesService;

    @ResponseBody
    @RequestMapping("/getWebCall")
    public ResponseResult<String> getWebCall(HttpServletRequest httpServletRequest) {
        ResponseResult<String> responseResult = new ResponseResult<String>();
        try {
            String code = httpServletRequest.getParameter("code");
            String state = httpServletRequest.getParameter("state");
            logger.info("\n授权获取code-JdCallBackController-getWebCall：" + "\n" +
                    "code:" + code + "\n" +
                    "state:" + state + "\n");
            String data = "";
            if (Objects.equals(state, 1)) {
                ResponseResult<String> token = getToken(code);
                data = token.getData();
            }
            responseResult.setCode(0);
            responseResult.setData(data);
            responseResult.setMessage(ReturnCode.getMsg(0));
        } catch (Exception e) {
            responseResult.setCode(-1);
            responseResult.setMessage(ReturnCode.getMsg(1));
            logger.error("[JdCallBackController]-[getWebCall],错误信息：" + e.getMessage());
        }
        return responseResult;
    }

    /**
     * des: jos  回调接口配置
     *
     * @author Janloong
     * @create 17-7-12 下午3:21
     **/
    @ResponseBody
    @RequestMapping("/getcall")
    public ResponseResult<String> getcall(HttpServletRequest httpServletRequest) {
        ResponseResult<String> responseResult = new ResponseResult<String>();
        try {
            String code = httpServletRequest.getParameter("code");
            String state = httpServletRequest.getParameter("state");
            logger.info("\n授权获取code-JdCallBackController-getcall：" + "\n" +
                    "code:" + code + "\n" +
                    "state:" + state + "\n");
            String data = "";
            if (Objects.equals(state, 1)) {
                ResponseResult<String> token = getToken(code);
                data = token.getData();
            }

            responseResult.setCode(0);
            responseResult.setData(data);
            responseResult.setMessage(ReturnCode.getMsg(0));
        } catch (Exception e) {
            responseResult.setCode(-1);
            responseResult.setMessage(ReturnCode.getMsg(1));
            logger.error("[JdCallBackController]-[getcall],错误信息：" + e.getMessage());
        }
        return responseResult;
    }

    /**
     * des: 获取京东code
     *
     * @author Janloong
     * @create 17-7-12 上午10:30
     **/
    @ResponseBody
    @RequestMapping("/getCode")
    public ResponseResult<String> getCode() {
        ResponseResult<String> responseResult = new ResponseResult<String>();
        try {
            String appkey = JdRequestManager.appKey;
            //String reidrect_uri = "http://www.yijiao2o.cn/bingdg-web/jingdg/getCall";
            String reidrect_uri = "http://www.yijiao2o.cn/bingdg-web/jingdg/getWebCall";
            Integer state = 1;
            String url = "https://oauth.jd.com/oauth/authorize?response_type=code&client_id=" + appkey + "&" +
                    "redirect_uri=" + reidrect_uri + "&state=" + state;
            //String result = HttpUtils.post(url);
            responseResult.setCode(0);
            responseResult.setData(url);
            responseResult.setMessage(ReturnCode.getMsg(0));
        } catch (Exception e) {
            responseResult.setCode(-1);
            responseResult.setMessage(ReturnCode.getMsg(1));
            logger.error("[JdCallBackController]-[getCode],错误信息：" + e.getMessage());
        }
        return responseResult;
    }

    /**
     * des: 获取京东 token
     *
     * @author Janloong
     * @create 17-7-12 上午10:31
     **/
    @ResponseBody
    @RequestMapping("/getToken")
    public ResponseResult<String> getToken(String code) {
        ResponseResult<String> responseResult = new ResponseResult<String>();
        try {
            String appKey = JdRequestManager.appKey;
            //String code = "";
            //String reidrect_uri = "http://www.yijiao2o.cn/bingdg-web/jingdg/getCall";
            String reidrect_uri = "http://www.yijiao2o.cn/bingdg-web/jingdg/getWebCall";
            String appSecret = JdRequestManager.appSecret;
            String url = "https://oauth.jd.com/oauth/token?grant_type=authorization_code&client_id=" + appKey
                    + "&client_secret=" + appSecret
                    + "&scope=read&redirect_uri=" + reidrect_uri + "&code=" + code
                    + "&state=2";
            String result = HttpUtils.post(url);
            logger.info("\n获取token-JdCallBackController-getToken：" + "\n" +
                    "result:" + result + "\n");
            responseResult.setCode(0);
            responseResult.setData(result);
            responseResult.setMessage(ReturnCode.getMsg(0));
        } catch (Exception e) {
            responseResult.setCode(-1);
            responseResult.setMessage(ReturnCode.getMsg(1));
            logger.error("[JdCallBackController]-[getToken],错误信息：" + e.getMessage());
        }
        return responseResult;
    }

    /**
     * des: 调用京东方法接口
     *
     * @author Janloong
     * @create 17-7-12 下午5:59
     **/
    @ResponseBody
    @RequestMapping("/getMethodRequest")
    public ResponseResult<String> getMethodRequest(String data, String enumMethod) {
        ResponseResult<String> responseResult = new ResponseResult<String>();
        try {
            logger.info("\n方法接受参数-JdCallBackController-getMethodRequest：" + "\n" +
                    "data:" + data + "\n" +
                    "enumMethod:" + enumMethod + "\n"
            );
            JSONObject jsonObject = JSONObject.parseObject(data);
            JdMethod leiMu = JdMethod.valueOf(enumMethod);
            JdRequestManager jdRequestManager = new JdRequestManager();
            String result = jdRequestManager.getResult(jsonObject, leiMu);
            responseResult.setCode(0);
            responseResult.setData(result);
            responseResult.setMessage(ReturnCode.getMsg(0));
        } catch (Exception e) {
            responseResult.setCode(-1);
            responseResult.setMessage(ReturnCode.getMsg(1));
            logger.error("[JdCallBackController]-[getMethodRequest],错误信息：" + e.getMessage());
        }
        return responseResult;
    }


    @ResponseBody
    @RequestMapping("/getRequestBySdk")
    public ResponseResult<Integer> getRequestBySdk(String data, String enumMethod) {
        ResponseResult<Integer> responseResult = new ResponseResult<Integer>();
        try {
            int i = -1;
            JdRequestManager jdRequestManager = new JdRequestManager();
            JSONObject result = jdRequestManager.getRequestByJdSdk(data, enumMethod);
            logger.info("\n请求测试-JdCallBackController-getRequestBySdk：" + "\n" +
                    "result:" + result + "\n" +
                    "data:" + data + "\n" +
                    "enumMethod:" + enumMethod + "\n"
            );
            //
            JdMethod method = JdMethod.valueOf(enumMethod);
            switch (method) {
                //根据父类目获取子类目
                case FINDBYPID:
                    i = systemCategoryService.insertListWithSystemCatergory(result, method);

                    break;
                //根据类目id获取属性列表
                case FINDATTRSBYCATEGORYID:
                    systemCategoryAttrService.insertSystemCatergoryAttrList(result, method);
                    break;
                //根据类目属性id 获取属性值列表
                case FINDVALUESBYATTRID:
                    systemCategoryAttrValuesService.insertSystemCatergoryAttrValues(result, method);
                    break;
                case FINDATTRBYID:

                    break;
                case FINDATTRBYIDJOS:
                    break;
                case WARE:
                    break;
                case FINDVALUESBYID:
                    break;
                case FINDVALUESBYIDJOS:
                    break;
                case GET:
                    break;
                case FINDATTRSBYCATEGORYIDJOS:
                    break;
                case FINDVALUESBYATTRIDJOS:
                    break;
                case FINDBYID:
                    break;
                default:
                    break;
            }


            responseResult.setCode(0);
            responseResult.setData(i);
            responseResult.setMessage(ReturnCode.getMsg(0));
        } catch (Exception e) {
            responseResult.setCode(-1);
            responseResult.setMessage(ReturnCode.getMsg(1));
            logger.error("[JdCallBackController]-[getRequestBySdk],错误信息：" + e.getMessage());
        }
        return responseResult;
    }

    /**
     * des: 抓取京东类目数据工具
     *
     * @author Janloong
     * @create 17-7-18 下午6:26
     **/
    @ResponseBody
    @RequestMapping("/getjingdgCategory")
    public ResponseResult<Integer> getjingdgCategory() {
        ResponseResult<Integer> responseResult = new ResponseResult<Integer>();
        try {

            for (int j = 1; j < 3; j++) {
                List<SystemCategory> idByCategortLev = systemCategoryService.getIdByCategortLev(j);
                //获取每个一级类目的id值
                idByCategortLev.forEach((k) -> {
                    Long id = k.getId();
                    String data = "{\"parentCid\":\"" + id + "\",\"field\":\"\"}";
                    String enumMethod = "FINDBYPID";
                    getRequestBySdk(data, enumMethod);
                    logger.info("当前类目等级: " + k.getLev() + "----------" + k.getName() + "/" + idByCategortLev.size() +
                            "---------------");
                });
            }
            responseResult.setCode(0);
            responseResult.setData(null);
            responseResult.setMessage(ReturnCode.getMsg(0));
        } catch (Exception e) {
            responseResult.setCode(-1);
            responseResult.setMessage(ReturnCode.getMsg(1));
            logger.error("[JdCallBackController]-[getjingdgCategory],错误信息：" + e.getMessage());
        }
        return responseResult;
    }

    /**
     * des: 获取类目属性列表
     *
     * @author Janloong
     * @create 17-7-19 下午12:12
     **/
    @ResponseBody
    @RequestMapping("/getCategoryAttr")
    public ResponseResult<Integer> getCategoryAttr() {
        ResponseResult<Integer> responseResult = new ResponseResult<Integer>();
        try {
            List<SystemCategory> idByCategortLev = systemCategoryService.getIdByCategortLev(3);

            idByCategortLev.forEach(k -> {
                Long id = k.getId();
                String data = "{\"cid\":\"" + id + "\",\"field\":\"\",\"attributeType\":\"\"}";
                String enumMethod = "FINDATTRSBYCATEGORYID";
                getRequestBySdk(data, enumMethod);
                logger.info("当前类目等级: " + k.getLev() + "----------" + k.getName() + "/" + idByCategortLev.size() +
                        "---------------");
            });
            responseResult.setCode(0);
            responseResult.setData(null);
            responseResult.setMessage(ReturnCode.getMsg(0));
        } catch (Exception e) {
            responseResult.setCode(-1);
            responseResult.setMessage(ReturnCode.getMsg(1));
            logger.error("[JdCallBackController]-[getCategoryAttr],错误信息：" + e.getMessage());
        }
        return responseResult;
    }

    /**
     * des: 获取京东类目属性值选项
     *
     * @author Janloong
     * @create 17-7-19 下午2:36
     **/
    @ResponseBody
    @RequestMapping("/getCategoryAttrValues")
    public ResponseResult<Integer> getCategoryAttrValues() {
        ResponseResult<Integer> responseResult = new ResponseResult<Integer>();
        try {
            //获取属性列表
            List<SystemCategoryAttr> categoryAttrList = systemCategoryAttrService.getCategoryAttrList();

            categoryAttrList.forEach(k -> {
                Long categoryAttrId = k.getCategoryAttrId();
                String data = "{\"categoryAttrId\":\"" + categoryAttrId + "\",\"field\":\"\"}";
                String enumMethod = "FINDVALUESBYATTRID";
                 getRequestBySdk(data, enumMethod);
                logger.info("当前属性id: " + k.getAttrId() + "----------" + k.getAttName() + "/" + categoryAttrList.size() +
                        "---------------");
            });
            responseResult.setCode(0);
            responseResult.setData(null);
            responseResult.setMessage(ReturnCode.getMsg(0));
        } catch (Exception e) {
            responseResult.setCode(-1);
            responseResult.setMessage(ReturnCode.getMsg(1));
            logger.error("[JdCallBackController]-[getCategoryAttrValues],错误信息：" + e.getMessage());
        }
        return responseResult;
    }
}
