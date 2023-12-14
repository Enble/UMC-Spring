package umc.spring.web.dto.member_mission;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberMissionResponseDto {

    private MemberMissionResponseDto() {
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateMemberMissionResultDto {
        Long memberMissionId;
        LocalDateTime createdAt;
    }
}
