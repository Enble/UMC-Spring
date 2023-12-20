package umc.spring.service.mission;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;

public interface MissionQueryService {
    Page<Mission> getMissionList(Long shopId, Integer page);
}
