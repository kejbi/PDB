package pl.biegajski.parish.mappers;

import org.springframework.stereotype.Component;
import pl.biegajski.parish.controllers.viewmodel.MemberViewModel;
import pl.biegajski.parish.model.entities.Member;
import pl.biegajski.parish.model.entities.Sex;

import java.time.LocalDate;

@Component
public class MemberMapper implements MapperInterface<Member, MemberViewModel> {

    @Override
    public MemberViewModel convertToViewModel(Member member) {
        return new MemberViewModel(
                member.getMemberId(),
                member.getName(),
                member.getSurname(),
                member.getSex().name(),
                member.getDateOfBirth().toString(),
                member.getOccupation(),
                member.getFamily().getFamilyId()
        );
    }

    @Override
    public Member convertToEntity(MemberViewModel memberViewModel) {
        return new Member(
                memberViewModel.getName(),
                memberViewModel.getSurname(),
                memberViewModel.getSex().equals("male") ? Sex.MALE : Sex.FEMALE,
                LocalDate.parse(memberViewModel.getDate()),
                memberViewModel.getOccupation()
        );
    }
}
