package umc.spring.converter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import umc.spring.domain.Mission;
import umc.spring.web.dto.mission.MissionRequestDto.CreateMissionDto;
import umc.spring.web.dto.mission.MissionResponseDto.CreateMissionResultDto;

public class MissionConverter {

    private MissionConverter() {
    }

    public static CreateMissionResultDto toCreateResultDto(Mission mission) {
        return CreateMissionResultDto.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(CreateMissionDto dto) {
        return Mission.builder()
                .point(dto.getPoint())
                .classificationNumber(dto.getClassificationNumber())
                .body(dto.getBody())
                .memberMissionList(new ArrayList<>())
                .build();
    }
}
