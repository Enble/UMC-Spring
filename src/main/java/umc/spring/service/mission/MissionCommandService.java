package umc.spring.service.mission;

import umc.spring.domain.Mission;
import umc.spring.web.dto.mission.MissionRequestDto;

public interface MissionCommandService {
    Mission createMission(MissionRequestDto.CreateMissionDto missionRequestDto);
}
