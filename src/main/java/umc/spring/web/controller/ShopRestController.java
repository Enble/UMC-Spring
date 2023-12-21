package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apipayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.ShopConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Shop;
import umc.spring.service.mission.MissionCommandService;
import umc.spring.service.mission.MissionQueryService;
import umc.spring.service.review.ReviewCommandService;
import umc.spring.service.review.ReviewQueryService;
import umc.spring.service.shop.ShopCommandService;
import umc.spring.validation.annotation.ExistShop;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.web.dto.mission.MissionRequestDto;
import umc.spring.web.dto.mission.MissionResponseDto;
import umc.spring.web.dto.mission.MissionResponseDto.CreateMissionResultDto;
import umc.spring.web.dto.review.ReviewRequestDto;
import umc.spring.web.dto.review.ReviewResponseDto;
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
    private final MissionCommandService missionCommandService;
    private final ReviewQueryService reviewQueryService;
    private final MissionQueryService missionQueryService;

    @PostMapping
    public ApiResponse<CreateShopResultDto> createShop(@RequestBody @Valid ShopRequestDto.CreateShopDto request) {
        Shop shop = shopCommandService.createShop(request);
        return ApiResponse.onSuccess(ShopConverter.toCreateResultDto(shop));
    }

    @PostMapping("/reviews")
    public ApiResponse<CreateReviewResultDto> createReview(
            @RequestBody @Valid ReviewRequestDto.CreateReviewDto request) {
        Review review = reviewCommandService.createReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toCreateResultDto(review));
    }

    @PostMapping("/missions")
    public ApiResponse<CreateMissionResultDto> createMission(
            @RequestBody @Valid MissionRequestDto.CreateMissionDto request) {
        Mission mission = missionCommandService.createMission(request);
        return ApiResponse.onSuccess(MissionConverter.toCreateResultDto(mission));
    }

    @GetMapping("/{shopId}/reviews")
    @Operation(summary = "가게 리뷰 목록 조회", description = "가게 리뷰 목록을 조회하며, 페이징을 포함합니다. query string으로 page 번호를 받습니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "shopId", description = "가게 id, path variable 입니다.", required = true),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1페이지 입니다.", required = true)
    })
    public ApiResponse<ReviewResponseDto.ReviewPreviewListDto> getReviewList(
            @ExistShop @PathVariable(name = "shopId") Long shopId,
            @CheckPage @RequestParam(name = "page") Integer page) {
        Page<Review> reviewList = reviewQueryService.getReviewList(shopId, page - 1);
        return ApiResponse.onSuccess(ReviewConverter.toReviewPreviewListDto(reviewList));
    }

    @GetMapping("/{shopId}/missions")
    @Operation(summary = "가게 미션 목록 조회", description = "가게 미션 목록을 조회하며, 페이징을 포함합니다. query string으로 page 번호를 받습니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "성공"),
    })
    @Parameters({
            @Parameter(name = "shopId", description = "가게 id, path variable 입니다.", required = true),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1페이지 입니다.", required = true)
    })
    public ApiResponse<MissionResponseDto.MissionPreviewListDto> getMissionList(
            @ExistShop @PathVariable(name = "shopId") Long shopId,
            @CheckPage @RequestParam(name = "page") Integer page) {
        Page<Mission> missionList = missionQueryService.getMissionList(shopId, page - 1);
        return ApiResponse.onSuccess(MissionConverter.toMissionPreviewListDto(missionList));
    }
}
