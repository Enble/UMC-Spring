package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apipayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.member.MemberCommandService;
import umc.spring.service.member_mission.MemberMissionCommandService;
import umc.spring.service.member_mission.MemberMissionQueryService;
import umc.spring.service.review.ReviewQueryService;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.web.dto.member.MemberRequestDto;
import umc.spring.web.dto.member.MemberResponseDto.JoinMemberResultDto;
import umc.spring.web.dto.member_mission.MemberMissionRequestDto;
import umc.spring.web.dto.member_mission.MemberMissionResponseDto.CreateMemberMissionResultDto;
import umc.spring.web.dto.mission.MissionResponseDto.MissionPreviewListDto;
import umc.spring.web.dto.review.ReviewResponseDto;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberMissionCommandService memberMissionCommandService;
    private final ReviewQueryService reviewQueryService;
    private final MemberMissionQueryService memberMissionQueryService;

    @PostMapping()
    public ApiResponse<JoinMemberResultDto> join(@RequestBody @Valid MemberRequestDto.JoinMemberDto request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @PostMapping("/missions")
    public ApiResponse<CreateMemberMissionResultDto> challengeMission(
            @RequestBody @Valid MemberMissionRequestDto.CreateMemberMissionDto request) {
        MemberMission memberMission = memberMissionCommandService.createMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toCreateResultDto(memberMission));
    }

    @GetMapping("/{memberId}/reviews")
    @Operation(summary = "회원이 작성한 리뷰 조회", description = "회원이 작성한 리뷰를 조회. 페이징을 포함합니다. query parameter로 page를 받습니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "성공"),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원 번호", required = true),
            @Parameter(name = "page", description = "페이지 번호", required = true),
    })
    public ApiResponse<ReviewResponseDto.ReviewPreviewListDto> getMemberReviewList(
            @ExistMember @PathVariable(name = "memberId") Long memberId,
            @CheckPage @RequestParam(name = "page") Integer page) {
        Page<Review> memberReviewList = reviewQueryService.getMemberReviewList(memberId, page - 1);
        return ApiResponse.onSuccess(ReviewConverter.toReviewPreviewListDto(memberReviewList));
    }

    @GetMapping("/{memberId}/missions")
    @Operation(summary = "회원이 도전한 미션 조회", description = "회원이 도전한 미션을 조회. 페이징을 포함합니다. query parameter로 page를 받습니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "성공"),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원 번호", required = true),
            @Parameter(name = "page", description = "페이지 번호", required = true),
    })
    public ApiResponse<MissionPreviewListDto> getMemberMissionList(
            @ExistMember @PathVariable(name = "memberId") Long memberId,
            @CheckPage @RequestParam(name = "page") Integer page) {
        Page<MemberMission> memberMissionList = memberMissionQueryService.getMemberMissionList(memberId, page - 1);
        return ApiResponse.onSuccess(MemberMissionConverter.toMissionPreviewListDto(memberMissionList));
    }

    @PatchMapping("/missions/{memberMissionId}")
    @Operation(summary = "회원 미션 완료", description = "회원 미션을 완료합니다.")
    public void completeMemberMission(
            @PathVariable(name = "memberMissionId") Long memberMissionId) {
        memberMissionCommandService.completeMemberMission(memberMissionId);
    }
}
