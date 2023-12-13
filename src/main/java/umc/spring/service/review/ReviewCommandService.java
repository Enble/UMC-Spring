package umc.spring.service.review;

import umc.spring.domain.Review;
import umc.spring.web.dto.review.ReviewRequestDto;

public interface ReviewCommandService {
    Review createReview(ReviewRequestDto.CreateDto reviewCommandDto);
}
