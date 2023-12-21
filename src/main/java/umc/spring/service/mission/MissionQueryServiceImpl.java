package umc.spring.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.domain.Shop;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.ShopRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final ShopRepository shopRepository;
    private final MissionRepository missionRepository;

    @Override
    public Page<Mission> getMissionList(Long shopId, Integer page) {
        Shop shop = shopRepository.findById(shopId).get();
        return missionRepository.findAllByShop(shop, PageRequest.of(page, 10));
    }

}
