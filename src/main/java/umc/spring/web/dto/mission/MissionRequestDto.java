package umc.spring.web.dto.mission;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistShop;

public class MissionRequestDto {

    private MissionRequestDto() {
    }

    @Getter
    public static class CreateMissionDto {
        @NotNull
        Integer point;
        @NotBlank
        String classificationNumber;
        @NotBlank
        String body;
        @ExistShop
        Long shopId;
    }
}
