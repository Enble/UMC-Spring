package umc.spring.converter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import umc.spring.domain.Shop;
import umc.spring.web.dto.shop.ShopRequestDto.CreateShopDto;
import umc.spring.web.dto.shop.ShopResponseDto.CreateShopResultDto;

public class ShopConverter {

    private ShopConverter() {
    }

    public static CreateShopResultDto toCreateResultDto(Shop shop) {
        return CreateShopResultDto.builder()
                .shopId(shop.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Shop toShop(CreateShopDto dto) {
        return Shop.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .score(0.0)
                .reviewList(new ArrayList<>())
                .missionList(new ArrayList<>())
                .build();
    }
}
