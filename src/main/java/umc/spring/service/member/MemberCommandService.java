package umc.spring.service.member;

import umc.spring.domain.Member;
import umc.spring.web.dto.member.MemberRequestDto;

public interface MemberCommandService {
    Member joinMember(MemberRequestDto.JoinDTO request);
}