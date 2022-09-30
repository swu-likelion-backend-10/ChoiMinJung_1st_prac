package com.likelionswu.backend_1hw.post.controller;


import com.likelionswu.backend_1hw.post.domain.Info;
import com.likelionswu.backend_1hw.post.dto.InfoDto;
import com.likelionswu.backend_1hw.post.service.InfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InfoController {
    private final InfoService infoService;

    public InfoController(InfoService infoService){
        this.infoService=infoService;
    }

    @GetMapping("/")
    public String home(Model model){
        List<InfoDto> infoDtoList = infoService.getInfoList();
        model.addAttribute("infoList", infoDtoList);
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

    @GetMapping("/enroll/{no}")
    public String detail(@PathVariable("no") Long id, Model model){
        InfoDto infoDto = infoService.getPost(id);

        model.addAttribute("infoDto", infoDto);
        return "Info/detail.html";
    }

    @GetMapping("/enroll/edit/{no}")
    public String edit(@PathVariable("no") Long id, Model model){
        InfoDto infoDto = infoService.getPost(id);

        model.addAttribute("infoDto", infoDto);
        return "Info/update.html";
    }

    @PutMapping("/enroll/edit/{no}")
    public String update(@PathVariable("no") Long id, InfoDto infoDto){
        infoService.updatePost(id, infoDto);
        return "redirect:/enroll/{no}";
    }

    @DeleteMapping("/enroll/delete/{no}")
    public String delete(@PathVariable("no") Long id){
        infoService.deletePost(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value="keyword") String keyword, Model model)  {

        List<InfoDto> infoDtoList = infoService.searchPosts(keyword);

        model.addAttribute("infoList", infoDtoList);

        return "Info/home.html";
    }
}
