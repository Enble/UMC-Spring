package umc.spring.converter;

import java.time.LocalDateTime;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.member_mission.MemberMissionResponseDto.CreateMemberMissionResultDto;

public class MemberMissionConverter {

    private MemberMissionConverter() {
    }

    public static CreateMemberMissionResultDto toCreateResultDto(MemberMission memberMission) {
        return CreateMemberMissionResultDto.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
