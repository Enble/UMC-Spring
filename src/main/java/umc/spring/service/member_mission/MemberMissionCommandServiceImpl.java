package umc.spring.service.member_mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.apipayload.exception.handler.MemberHandler;
import umc.spring.apipayload.exception.handler.MissionHandler;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.member_mission.MemberMissionRequestDto.CreateMemberMissionDto;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public MemberMission createMemberMission(CreateMemberMissionDto request) {
        MemberMission memberMission = MemberMission.builder()
                .status(MissionStatus.IN_PROGRESS)
                .build();

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        memberMission.setMember(member);

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        memberMission.setMission(mission);

        return memberMissionRepository.save(memberMission);
    }

    @Override
    @Transactional
    public void completeMemberMission(Long memberMissionId) {
        MemberMission memberMission = memberMissionRepository.findById(memberMissionId)
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MEMBER_MISSION_NOT_FOUND));
        memberMission.completeMission();
    }


}
