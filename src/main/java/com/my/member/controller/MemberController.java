package com.my.member.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MemberController {
    @GetMapping("/list")
    public String showList(){
        return "showMember";
    }
}