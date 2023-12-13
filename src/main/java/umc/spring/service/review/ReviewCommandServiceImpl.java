package umc.spring.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.apipayload.exception.handler.MemberHandler;
import umc.spring.apipayload.exception.handler.ReviewHandler;
import umc.spring.apipayload.exception.handler.ShopHandler;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Shop;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.ShopRepository;
import umc.spring.web.dto.review.ReviewRequestDto;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final MemberRepository memberRepository;
    private final ShopRepository shopRepository;
    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public Review createReview(ReviewRequestDto.CreateDto request) {
        Review review = ReviewConverter.toReview(request);

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        review.setMember(member);

        Shop shop = shopRepository.findById(request.getShopId())
                .orElseThrow(() -> new ShopHandler(ErrorStatus.SHOP_NOT_FOUND));
        review.setShop(shop);

        return reviewRepository.save(review);
    }
}
