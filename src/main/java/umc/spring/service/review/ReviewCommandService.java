package umc.spring.service.review;

import umc.spring.domain.Review;
import umc.spring.web.dto.review.ReviewRequestDto.CreateReviewDto;

public interface ReviewCommandService {
    Review createReview(CreateReviewDto reviewCommandDto);
}
