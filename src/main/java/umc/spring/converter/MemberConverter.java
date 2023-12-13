package umc.spring.converter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import umc.spring.domain.Member;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.member.MemberRequestDto.JoinMemberDto;
import umc.spring.web.dto.member.MemberResponseDto.JoinMemberResultDto;

public class MemberConverter {

    public static JoinMemberResultDto toJoinResultDTO(Member member){
        return JoinMemberResultDto.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(JoinMemberDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .specAddress(request.getSpecAddress())
                .birthday(request.getBirthday())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }

}
