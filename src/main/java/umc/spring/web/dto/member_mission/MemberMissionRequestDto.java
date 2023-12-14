package umc.spring.web.dto.member_mission;

import javax.validation.constraints.NotNull;
import lombok.Getter;

public class MemberMissionRequestDto {

    private MemberMissionRequestDto() {
    }

    @Getter
    public static class CreateMemberMissionDto {
        @NotNull
        Long missionId;
        @NotNull
        Long memberId;
    }
}
