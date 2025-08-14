package com.my.member.controller;

import com.my.member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.my.member.service.MemberService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/member/insertForm")
    public String insertFormView(){
        return "insertForm";
    }

    @PostMapping("/member/insert")
    public  String insert(MemberDto dto){
        System.out.println(dto);
        service.insertMember(dto);
        // 폼에서 보낸 정보를 dto로 받는다.
        // 받은 DTO를 서비스로 보낸다.
        // 서비스에서 DTO를 엔티티로 바꾼다.
        // 리포지토리를 이용해 저장한다.
        // 메인리스트 화면으로 돌아간다.
        return "redirect:/list";
    }

    @PostMapping("/member/delete/{id}")
    public String deleteMember(@PathVariable("id")Long id){
        service.deleteMember(id);
        return "redirect:/list";
    }
}