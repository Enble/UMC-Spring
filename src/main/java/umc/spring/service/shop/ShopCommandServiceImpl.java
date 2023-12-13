package umc.spring.service.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.apipayload.exception.handler.RegionHandler;
import umc.spring.converter.ShopConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Shop;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.ShopRepository;
import umc.spring.web.dto.shop.ShopRequestDto.CreateShopDto;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShopCommandServiceImpl implements ShopCommandService {

    private final ShopRepository shopRepository;

    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Shop createShop(CreateShopDto dto) {
        Shop shop = ShopConverter.toShop(dto);
        Region region = regionRepository.findById(dto.getRegionId())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
        shop.setRegion(region);

        return shopRepository.save(shop);
    }
}
