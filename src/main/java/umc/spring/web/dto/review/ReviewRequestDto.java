package umc.spring.web.dto.review;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDto {

    private ReviewRequestDto() {
    }

    @Getter
    public static class CreateDto {
        @NotNull
        Integer star;
        @NotBlank
        String title;
        @NotBlank
        String body;
    }
}
