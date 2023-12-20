package umc.spring.service.member_mission;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.member_mission.MemberMissionRequestDto.CreateMemberMissionDto;

public interface MemberMissionCommandService {
    MemberMission createMemberMission(CreateMemberMissionDto memberMissionRequestDto);
    void completeMemberMission(Long memberMissionId);
}
