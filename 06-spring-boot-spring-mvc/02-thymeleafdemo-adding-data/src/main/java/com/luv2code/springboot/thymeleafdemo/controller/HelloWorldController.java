package com.luv2code.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm(Model theModel){
        theModel.addAttribute("theDate", java.time.LocalDateTime.now());
      return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }
//    @RequestMapping("/processFormVersionTwo")
//    public String letsShout(HttpServletRequest request , Model theModel){
//
//        String theName = request.getParameter("studentName");
//        theName=theName.toUpperCase();
//        String result = "Hey! " + theName;
//        theModel.addAttribute("message",result);
//        return "helloworld";
//
//    }

    @PostMapping("/processFormVersionThree")
    public String letsShoutDude(@RequestParam("studentName") String name, Model model){
                                //studentName adli form alanini okuyacak ve name degiskenine baglicak
        name=name.toUpperCase();
        String result = "Hey! " + name;
        model.addAttribute("message",result);
        return "helloworld";

    }


}
