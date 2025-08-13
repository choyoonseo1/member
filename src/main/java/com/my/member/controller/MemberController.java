package com.my.member.controller;

import com.my.member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.my.member.service.MemberService;

import java.util.List;

@Controller
public class MemberController {
    // 서비스를 가져와 실행 할 준비를 한다.
    // 1. @Autowired 사용
    @Autowired
    MemberService service;

    @GetMapping("/list")
    public String showList(Model model){
        model.addAttribute("title", "리스트보기");
        // 서비스에 멤버리스트 정보 요청
        List<MemberDto> memberList = service.getAllList();
        model.addAttribute("list", memberList);
        return "showMember";
    }
}