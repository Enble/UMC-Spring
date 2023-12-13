package umc.spring.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.apipayload.exception.handler.ShopHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Shop;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.ShopRepository;
import umc.spring.web.dto.mission.MissionRequestDto.CreateMissionDto;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final ShopRepository shopRepository;

    @Override
    @Transactional
    public Mission createMission(CreateMissionDto request) {
        Mission mission = MissionConverter.toMission(request);

        Shop shop = shopRepository.findById(request.getShopId())
                .orElseThrow(() -> new ShopHandler(ErrorStatus.SHOP_NOT_FOUND));
        mission.setShop(shop);

        return missionRepository.save(mission);
    }
}
