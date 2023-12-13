package umc.spring.web.dto.review;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDto {

    private ReviewRequestDto() {
    }

    @Getter
    public static class CreateReviewDto {
        @NotNull
        Long memberId;
        @NotNull
        Long shopId;
        @NotNull
        Integer star;
        @NotBlank
        String title;
        @NotBlank
        String body;
    }
}
