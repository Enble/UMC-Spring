package umc.spring.converter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.web.dto.mission.MissionRequestDto.CreateMissionDto;
import umc.spring.web.dto.mission.MissionResponseDto.CreateMissionResultDto;
import umc.spring.web.dto.mission.MissionResponseDto.MissionPreviewDto;
import umc.spring.web.dto.mission.MissionResponseDto.MissionPreviewListDto;

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

    public static MissionPreviewListDto toMissionPreviewListDto(Page<Mission> missionList) {
        List<MissionPreviewDto> collect = missionList.stream().map(MissionConverter::toMissionPreviewDto)
                .collect(Collectors.toList());

        return MissionPreviewListDto.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(collect.size())
                .missionList(collect)
                .build();
    }

    public static MissionPreviewDto toMissionPreviewDto(Mission mission) {
        return MissionPreviewDto.builder()
                .point(mission.getPoint())
                .classificationNumber(mission.getClassificationNumber())
                .body(mission.getBody())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }
}
