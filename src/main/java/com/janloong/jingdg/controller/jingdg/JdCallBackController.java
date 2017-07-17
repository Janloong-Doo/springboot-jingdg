package com.janloong.jingdg.controller.jingdg;

import com.alibaba.fastjson.JSONObject;
import com.janloong.jingdg.controller.utils.ResponseResult;
import com.janloong.jingdg.controller.utils.ReturnCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sword.lang.HttpUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author Janloong
 * @create 2017-07-12 上午9:36
 **/
@Controller
@RequestMapping("/jingdg")
public class JdCallBackController {
    private static final Logger logger = LoggerFactory.getLogger(JdCallBackController.class);

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
    public ResponseResult<String> getRequestBySdk(String data, String enumMethod) {
        ResponseResult<String> responseResult = new ResponseResult<String>();
        try {
            JdRequestManager jdRequestManager = new JdRequestManager();
            String result = jdRequestManager.getRequestByJdSdk(data, enumMethod);
            //
            //JdMethod method = JdMethod.valueOf(enumMethod);
            //switch (method) {
            //    case FINDATTRBYID:
            //        CategoryReadFindAttrByIdRequest findAttrByIdRequest = JSONObject.parseObject(data, CategoryReadFindAttrByIdRequest.class);
            //        String requestBySDK = jdRequestManager.getRequestBySDK();
            //        break;
            //    case FINDATTRBYIDJOS:
            //        break;
            //    case WARE:
            //        break;
            //    case FINDVALUESBYID:
            //        break;
            //    case FINDVALUESBYIDJOS:
            //        break;
            //    case SEARCH:
            //        break;
            //    case GET:
            //        break;
            //    case FINDATTRSBYCATEGORYIDJOS:
            //        break;
            //    case FINDVALUESBYATTRIDJOS:
            //        break;
            //    case FINDVALUESBYATTRID:
            //        break;
            //    case FINDBYPID:
            //        break;
            //    case FINDBYID:
            //        break;
            //    case FINDATTRSBYCATEGORYID:
            //        break;
            //    default:
            //        break;
            //}


            responseResult.setCode(0);
            responseResult.setData(result);
            responseResult.setMessage(ReturnCode.getMsg(0));
        } catch (Exception e) {
            responseResult.setCode(-1);
            responseResult.setMessage(ReturnCode.getMsg(1));
            logger.error("[JdCallBackController]-[getRequestBySdk],错误信息：" + e.getMessage());
        }
        return responseResult;
    }
}
