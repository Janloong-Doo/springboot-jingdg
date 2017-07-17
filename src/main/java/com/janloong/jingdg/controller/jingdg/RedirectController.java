package com.janloong.jingdg.controller.jingdg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Janloong
 * @create 2017-07-15 下午2:58
 **/
@Controller
@RequestMapping("/redirect")
public class RedirectController {
    private static final Logger logger = LoggerFactory.getLogger(JdCallBackController.class);

    @ResponseBody
    @RequestMapping("/getRedirect")
    public void getRedirect(HttpServletResponse response, HttpServletRequest request) {
        try {
              logger.info("--------1-------");
            request.setAttribute("age",22);
            String age = request.getParameter("age");
            logger.info(age+"----------");

            //RequestDispatcher requestDispatcher = request.getRequestDispatcher("/redirect/dispatche?name=janloong");
            //requestDispatcher.forward(request,response);
            //requestDispatcher.include(request,response);
            //String parameter = request.getParameter("age");
            logger.info("--------2-------");
            //response.getOutputStream().print("111");
            //response.getOutputStream().print(parameter);
            response.sendRedirect("http://www.baidu.com");
            //response.sendRedirect("/bingdg-web/source/redirecttest.html?name=janloong");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @ResponseBody
    @RequestMapping("/dispatche")
    public void dispatche(HttpServletResponse response, HttpServletRequest request){
        try {
        String name = request.getParameter("name");
        Integer age = (Integer) request.getAttribute("age");

            response.getWriter().print(name);
            response.getWriter().print(age);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
