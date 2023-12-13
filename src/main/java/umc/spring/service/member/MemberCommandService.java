package umc.spring.service.member;

import umc.spring.domain.Member;
import umc.spring.web.dto.member.MemberRequestDto.JoinMemberDto;

public interface MemberCommandService {
    Member joinMember(JoinMemberDto request);
}
