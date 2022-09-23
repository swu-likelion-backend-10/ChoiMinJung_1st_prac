package com.likelionswu.backend_1hw.post.controller;


import com.likelionswu.backend_1hw.post.dto.InfoDto;
import com.likelionswu.backend_1hw.post.service.InfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InfoController {
    private final InfoService infoService;

    public InfoController(InfoService infoService){
        this.infoService=infoService;
    }

    @GetMapping("/")
    public String home(){

        return "Info/home.html";
    }

    @GetMapping("/enroll")
    public String write(){
        return "Info/write.html";
    }

    @PostMapping("/enroll")
    public String write(InfoDto infoDto){
        infoService.savePost(infoDto);
        return "redirect:/";
    }
}
