package cha.test.test1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cha.test.test1.service.FirstService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@RequestMapping("/layout")
@Log4j2
public class FirstController {

    private final FirstService service;

    @GetMapping("/main")
    public String moveMain(Model model){

        model.addAttribute("sysdate", service.getSysDate());

        return "todo/main";
    }
    
    
}