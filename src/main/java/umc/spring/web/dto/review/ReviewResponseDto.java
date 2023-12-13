package umc.spring.web.dto.review;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewResponseDto {

    private ReviewResponseDto() {
    }

    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class CreateReviewResultDto {
        Long reviewId;
        LocalDateTime createdAt;
    }
}
