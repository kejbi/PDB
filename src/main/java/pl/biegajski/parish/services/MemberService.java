package pl.biegajski.parish.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.biegajski.parish.model.entities.Member;
import pl.biegajski.parish.repositories.FamilyRepository;
import pl.biegajski.parish.repositories.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Optional<Member> findMemberById(Long id){
        return memberRepository.findById(id);
    }

    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }


}
