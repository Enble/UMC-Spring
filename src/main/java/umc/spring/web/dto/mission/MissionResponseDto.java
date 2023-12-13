package umc.spring.web.dto.mission;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MissionResponseDto {

    private MissionResponseDto() {
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class CreateMissionResultDto {
        Long missionId;
        LocalDateTime createdAt;
    }
}
