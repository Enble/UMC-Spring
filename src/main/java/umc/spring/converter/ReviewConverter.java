package umc.spring.converter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.web.dto.review.ReviewRequestDto.CreateReviewDto;
import umc.spring.web.dto.review.ReviewResponseDto.CreateReviewResultDto;
import umc.spring.web.dto.review.ReviewResponseDto.ReviewPreviewDto;
import umc.spring.web.dto.review.ReviewResponseDto.ReviewPreviewListDto;

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
                .star(dto.getScore())
                .title(dto.getTitle())
                .body(dto.getBody())
                .build();
    }

    public static ReviewPreviewListDto toReviewPreviewListDto(Page<Review> reviewList) {
        List<ReviewPreviewDto> collect = reviewList.stream().map(ReviewConverter::toReviewPreviewDto)
                .collect(Collectors.toList());

        return ReviewPreviewListDto.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(collect.size())
                .reviewList(collect)
                .build();
    }

    public static ReviewPreviewDto toReviewPreviewDto(Review review) {
        return ReviewPreviewDto.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getStar())
                .body(review.getBody())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }
}
