package umc.spring.service.member_mission;

import org.springframework.data.domain.Page;
import umc.spring.domain.mapping.MemberMission;

public interface MemberMissionQueryService {
    Page<MemberMission> getMemberMissionList(Long memberId, Integer page);
}
