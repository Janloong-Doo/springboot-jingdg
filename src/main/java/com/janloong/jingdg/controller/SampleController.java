package com.janloong.jingdg.controller;

import com.janloong.jingdg.controller.utils.ResponseResult;
import com.janloong.jingdg.controller.utils.ReturnCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Janloong
 * @create 2017-07-15 下午12:24
 **/
@Controller
public class SampleController {

    @RequestMapping("/hello")
    @ResponseBody
    public void home(HttpServletResponse response, HttpServletRequest request) {
        try {
        String name = request.getParameter("name");

            response.sendRedirect("localhost:8080/templates/SampleController.html?name="+name);

        } catch (IOException e) {
            e.getMessage();
        }
    }
    @ResponseBody
    @RequestMapping("/hehe")
    public ResponseResult<String> hehe() {
        ResponseResult<String> responseResult = new ResponseResult<String>();
        try {

            responseResult.setCode(0);
            responseResult.setData("hhe");
            responseResult.setMessage(ReturnCode.getMsg(0));
        } catch (Exception e) {
            responseResult.setCode(-1);
            responseResult.setMessage(ReturnCode.getMsg(1));
        }
        return responseResult;
    }
}
