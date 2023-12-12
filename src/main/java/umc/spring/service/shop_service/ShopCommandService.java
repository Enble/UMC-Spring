package umc.spring.service.shop_service;

import umc.spring.domain.Shop;
import umc.spring.web.dto.shop.ShopRequestDto;

public interface ShopCommandService {
    Shop createShop(ShopRequestDto.CreateDto dto);
}
