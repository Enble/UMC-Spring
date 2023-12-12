package umc.spring.service.shop_service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.apipayload.exception.handler.RegionHandler;
import umc.spring.converter.ShopConverter;
import umc.spring.domain.Shop;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.ShopRepository;
import umc.spring.web.dto.ShopRequestDto;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShopCommandServiceImpl implements ShopCommandService {

    private final ShopRepository shopRepository;

    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Shop createShop(ShopRequestDto.CreateDto dto) {
        Shop shop = ShopConverter.toShop(dto);
        regionRepository.findById(dto.getRegionId()).orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));

        return shopRepository.save(shop);
    }
}
