package pl.biegajski.parish.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.biegajski.parish.controllers.viewmodel.MemberViewModel;
import pl.biegajski.parish.mappers.MemberMapper;
import pl.biegajski.parish.model.entities.Member;
import pl.biegajski.parish.services.MemberService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/member")
public class MemberController {

    private MemberService memberService;

    private MemberMapper mapper;

    @Autowired
    public MemberController(MemberService memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }

    @GetMapping
    public MemberViewModel findMemberById(@RequestParam Long id){
        var member = memberService.findMemberById(id).orElseThrow(EntityNotFoundException::new);
        return mapper.convertToViewModel(member);
    }

    @GetMapping("/all")
    public List<MemberViewModel> getAllMembers(){
        var members = memberService.getAllMembers();

        return members.stream()
                .map(member -> mapper.convertToViewModel(member))
                .collect(Collectors.toList());
    }

    @PostMapping
    public Member saveMember(@RequestBody @Valid MemberViewModel memberViewModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationException();
        }

        var member = mapper.convertToEntity(memberViewModel);

        return memberService.saveMember(member);
    }

    @DeleteMapping
    public void deleteMember(@RequestParam Long id){
        memberService.deleteMember(id);
    }


}
