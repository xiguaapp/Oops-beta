//package com.example.interceptor;
//
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.example.commonutils.JwtUtils;
//import com.example.commonutils.R;
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//@Component
//public class LoginInterceptor implements HandlerInterceptor {
//    Logger logger= LoggerFactory.getLogger(Logger.class);
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        response.setCharacterEncoding("utf-8");
//        String jwt=request.getHeader("token");
//        logger.info("token为{}",jwt);
//        if(!StringUtils.isEmpty(jwt)){
//           try{
//               DecodedJWT verify = JwtUtils.verify(jwt);
//               logger.info("此时正常 放行");
//               return true;
//           }catch (Exception e){
//               e.printStackTrace();
//           }
//            logger.info("token不存在jwt中");
//            response.setContentType("text/html;charset=UTF-8");
//            response.getWriter().println(R.error("token不存在jwt中").toString());
//            return  false;
//        }
//        logger.info("当前的值token 为空！");
//        response.setContentType("text/html;charset=UTF-8");
//        response.getWriter().println(R.error("当前的值token 为空！").toString());
//        return false;
//    }
//}
