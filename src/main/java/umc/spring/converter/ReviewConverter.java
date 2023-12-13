package umc.spring.converter;

import java.time.LocalDateTime;
import umc.spring.domain.Review;
import umc.spring.web.dto.review.ReviewRequestDto.CreateReviewDto;
import umc.spring.web.dto.review.ReviewResponseDto.CreateReviewResultDto;

public class ReviewConverter {

    private ReviewConverter() {
    }

    public static CreateReviewResultDto toCreateResultDto(Review review) {
        return CreateReviewResultDto.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(CreateReviewDto dto) {
        return Review.builder()
                .star(dto.getStar())
                .title(dto.getTitle())
                .body(dto.getBody())
                .build();
    }
}
