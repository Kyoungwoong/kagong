package com.example.kagong.controller;

import com.example.kagong.entity.Member;
import com.example.kagong.entity.University;
import com.example.kagong.repository.MemberRepository;
import com.example.kagong.service.MemberService;
import com.example.kagong.service.UniversityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
@Slf4j
public class HomeController {
    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    MemberService memberService;

    @Autowired
    UniversityService universityService;

    @PostMapping("/login")
    public Member viewProfile(@RequestBody String email, @RequestBody String password)
    {
        Member member = memberService.findByEmail(email);
        return member;
    }

    @GetMapping("/signup")
    public String test()
    {
        return "person";
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam String name,@RequestParam String email, @RequestParam String password) throws Exception
    {
        System.out.println("name = " + name);
        Member member = new Member(name, email, password);
        memberService.save(member);
        return "home";
    }

//    @PostMapping("/signup")
//    public Member signUp(@RequestBody String name,@RequestBody String email, @RequestBody String password)
//    {
//        System.out.println("name = " + name);
//        Member member = new Member(name, email, password);
//        memberService.save(member);
//        return member;
//    }

    @PostMapping("/{id}/enrollUniverse")
    public void enrollUniverse(@PathVariable("id") Long id, @RequestBody String univName)
    {
        Member member = memberService.findOne(id);
        University university = universityService.findUniversityByUnivName(univName);
        member.setUniversity(university);
    }
}
