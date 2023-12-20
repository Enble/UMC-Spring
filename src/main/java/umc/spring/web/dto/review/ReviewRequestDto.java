package umc.spring.web.dto.review;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.ExistShop;

public class ReviewRequestDto {

    private ReviewRequestDto() {
    }

    @Getter
    public static class CreateReviewDto {
        @NotNull
        Float score;
        @NotBlank
        String title;
        @NotBlank
        String body;
        @NotNull
        Long memberId;
        @ExistShop
        Long shopId;
    }

}
