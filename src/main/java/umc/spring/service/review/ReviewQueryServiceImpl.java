package umc.spring.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Shop;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.ShopRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final MemberRepository memberRepository;
    private final ShopRepository shopRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getReviewList(Long shopId, Integer page) {
        Shop shop = shopRepository.findById(shopId).get();
        return reviewRepository.findAllByShop(shop, PageRequest.of(page, 10));
    }

    @Override
    public Page<Review> getMemberReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();
        return reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
    }

}
