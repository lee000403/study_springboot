package com.example.study_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @GetMapping({"/", "/home", "/main"}) // getmapping 안에 {}을 사용하면 여러개의 url을 사용할 수 있다.
    public ModelAndView main(ModelAndView modelAndView){
        modelAndView.addObject("name", "이동환"); // jsp로 값을 넘기는 것이다. addObject랑 setAtribute 랑 같다.
        modelAndView.setViewName("/WEB-INF/views/main.jsp"); // WEB-INF 부터 인식 가능하므로 설정을 잘해줘야한다. /로도 바꾸어줘야한다.
        return modelAndView;
    }
}
