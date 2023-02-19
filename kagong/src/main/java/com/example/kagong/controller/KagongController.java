package com.example.kagong.controller;

import com.example.kagong.entity.Member;
import com.example.kagong.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class KagongController {

    private final MemberService memberService;
    @GetMapping("/another")
    public String kagongTest() {return "Spring boot react 연동 테스트";}

//    @GetMapping("/home")
//    public String signPage() {return "../../Frontend/src/pa";}

//    @PostMapping("/login")
//    public Member memberLogin(@RequestBody final Member params){
//        Member entity = memberService.findOne(params.getMemberId());
//        return entity;
//    }
//    @GetMapping("/check/nickname/{nickname}")
//    public ResponseEntity<?> checkNickname(@PathVariable("nickname") String nickname) {
//        log.info("Auth Service's Controller Layer :: Call checkNickname Method!");
//
//        if(memberService.checkNickname(nickname)) {
//            return ResponseEntity.status(HttpStatus.OK).body(false);
//        }
//
//        return ResponseEntity.status(HttpStatus.OK).body(true);
//    }
//
//    @GetMapping("/check/email/{email}")
//    public ResponseEntity<?> checkEmail(@PathVariable("email") String email) {
//        log.info("Auth Service's Controller Layer :: Call checkNickname Method!");
//
//        if(memberService.checkEmail(email)) {
//            return ResponseEntity.status(HttpStatus.OK).body(false);
//        }
//
//        return ResponseEntity.status(HttpStatus.OK).body(true);
//    }
//
//    @PostMapping("/signup")
//    public ResponseEntity<?> register(@RequestBody Member user){
//        Member newMember = new Member(user.getEmail(), user.getName(), user.getPassword());
//
////        if(!memberService.checkEmail(newMember.getEmail())){
////            return ResponseEntity.status()
////        }
////
////        return ResponseEntity.status(HttpStatus.CREATED)
////                .body()
//    }
}
