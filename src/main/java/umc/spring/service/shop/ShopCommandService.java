package umc.spring.service.shop;

import umc.spring.domain.Shop;
import umc.spring.web.dto.shop.ShopRequestDto.CreateShopDto;

public interface ShopCommandService {
    Shop createShop(CreateShopDto dto);
}
