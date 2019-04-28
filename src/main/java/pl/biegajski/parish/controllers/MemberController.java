package pl.biegajski.parish.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.biegajski.parish.model.entities.Member;
import pl.biegajski.parish.services.MemberService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/member")
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public Optional<Member> findFamilyById(@RequestParam Long id){
        return memberService.findMemberById(id);
    }

    @GetMapping("/all")
    public List<Member> getAllFamilies(){
        return memberService.getAllMembers();
    }



}
