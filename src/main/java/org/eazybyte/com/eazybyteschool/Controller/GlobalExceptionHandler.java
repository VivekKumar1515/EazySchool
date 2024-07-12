package org.eazybyte.com.eazybyteschool.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice(annotations = Controller.class)
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error");
        mav.addObject("errormsg", e.getMessage());
        return mav;
    }
}
