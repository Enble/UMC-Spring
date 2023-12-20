package umc.spring.service.review;

import java.util.Optional;
import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.Shop;

public interface ReviewQueryService {
    Page<Review> getReviewList(Long shopId, Integer page);
}
