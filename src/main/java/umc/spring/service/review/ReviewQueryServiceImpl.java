package umc.spring.service.review;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Review;
import umc.spring.domain.Shop;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.ShopRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ShopRepository shopRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getReviewList(Long shopId, Integer page) {
        Shop shop = shopRepository.findById(shopId).get();

        return reviewRepository.findAllByShop(shop, PageRequest.of(page, 10));
    }
}
