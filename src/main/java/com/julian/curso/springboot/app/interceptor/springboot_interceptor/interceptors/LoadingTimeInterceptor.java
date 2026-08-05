package com.julian.curso.springboot.app.interceptor.springboot_interceptor.interceptors;

import java.util.Random;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
                // Se puede hacer un cast a HandlerMethod para obtener información del método del controlador con una variable de tipo HandlerMethod
        HandlerMethod controller = ((HandlerMethod) handler);      
        logger.info("LoadingTimeInterceptor: preHandle() entrando... " + controller.getMethod().getName());

        long start = System.currentTimeMillis();
        request.setAttribute("start", start);
        Random random = new Random();
        int delay = random.nextInt(500);
        Thread.sleep(delay);
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        
        long end = System.currentTimeMillis();
        long start = (Long) request.getAttribute("start");
        long result = end - start;
        logger.info("Tiempo transcurrido: " + result + " milisegundos");
                // Se puede hacer un cast a HandlerMethod para obtener información del método del controlador directamente con handler como variable de tipo HandlerMethod
        logger.info("LoadingTimeInterceptor: postHandle() saliendo... " + ((HandlerMethod) handler).getMethod().getName());
    }

}
