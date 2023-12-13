package umc.spring.web.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apipayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.ShopConverter;
import umc.spring.domain.Review;
import umc.spring.domain.Shop;
import umc.spring.service.review.ReviewCommandService;
import umc.spring.service.shop.ShopCommandService;
import umc.spring.web.dto.review.ReviewRequestDto;
import umc.spring.web.dto.review.ReviewResponseDto.CreateReviewResultDto;
import umc.spring.web.dto.shop.ShopRequestDto;
import umc.spring.web.dto.shop.ShopResponseDto.CreateShopResultDto;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/shops")
public class ShopRestController {

    private final ShopCommandService shopCommandService;
    private final ReviewCommandService reviewCommandService;

    @PostMapping()
    public ApiResponse<CreateShopResultDto> create(@RequestBody @Valid ShopRequestDto.CreateShopDto request) {
        Shop shop = shopCommandService.createShop(request);
        return ApiResponse.onSuccess(ShopConverter.toCreateResultDto(shop));
    }

    @PostMapping("/reviews")
    public ApiResponse<CreateReviewResultDto> createReview(
            @RequestBody @Valid ReviewRequestDto.CreateReviewDto request) {
        Review review = reviewCommandService.createReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toCreateResultDto(review));
    }
}
