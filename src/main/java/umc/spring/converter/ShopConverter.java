package umc.spring.converter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import umc.spring.domain.Shop;
import umc.spring.web.dto.shop.ShopRequestDto;
import umc.spring.web.dto.shop.ShopResponseDto;

public class ShopConverter {

    private ShopConverter() {
    }

    public static ShopResponseDto.CreateResultDto toCreateResultDto(Shop shop) {
        return ShopResponseDto.CreateResultDto.builder()
                .shopId(shop.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Shop toShop(ShopRequestDto.CreateDto dto) {
        return Shop.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .score(0.0)
                .reviewList(new ArrayList<>())
                .missionList(new ArrayList<>())
                .build();
    }
}
