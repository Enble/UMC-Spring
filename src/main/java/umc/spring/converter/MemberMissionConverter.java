package umc.spring.converter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.member_mission.MemberMissionResponseDto.CreateMemberMissionResultDto;
import umc.spring.web.dto.mission.MissionResponseDto.MissionPreviewDto;
import umc.spring.web.dto.mission.MissionResponseDto.MissionPreviewListDto;

public class MemberMissionConverter {

    private MemberMissionConverter() {
    }

    public static CreateMemberMissionResultDto toCreateResultDto(MemberMission memberMission) {
        return CreateMemberMissionResultDto.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MissionPreviewListDto toMissionPreviewListDto(Page<MemberMission> missionList) {
        List<MissionPreviewDto> collect = missionList.stream().map(MemberMissionConverter::toMissionPreviewDto)
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

    public static MissionPreviewDto toMissionPreviewDto(MemberMission memberMission) {
        return MissionPreviewDto.builder()
                .point(memberMission.getMission().getPoint())
                .classificationNumber(memberMission.getMission().getClassificationNumber())
                .body(memberMission.getMission().getBody())
                .createdAt(memberMission.getMission().getCreatedAt().toLocalDate())
                .build();
    }
}
