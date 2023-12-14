package umc.spring.web.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apipayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.member.MemberCommandService;
import umc.spring.service.member_mission.MemberMissionCommandService;
import umc.spring.web.dto.member.MemberRequestDto;
import umc.spring.web.dto.member.MemberResponseDto.JoinMemberResultDto;
import umc.spring.web.dto.member_mission.MemberMissionRequestDto;
import umc.spring.web.dto.member_mission.MemberMissionResponseDto.CreateMemberMissionResultDto;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;
    private final MemberMissionCommandService memberMissionCommandService;

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
}
