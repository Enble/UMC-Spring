package umc.spring.converter;

import java.time.LocalDateTime;
import umc.spring.domain.Review;
import umc.spring.web.dto.review.ReviewRequestDto;
import umc.spring.web.dto.review.ReviewResponseDto;

public class ReviewConverter {

    private ReviewConverter() {
    }

    public static ReviewResponseDto.CreateResultDto toCreateResultDto(Review review) {
        return ReviewResponseDto.CreateResultDto.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDto.CreateDto dto) {
        return Review.builder()
                .star(dto.getStar())
                .title(dto.getTitle())
                .body(dto.getBody())
                .build();
    }
}
