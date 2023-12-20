package umc.spring.service.shop;

import java.util.Optional;
import umc.spring.domain.Shop;

public interface ShopQueryService {
    Optional<Shop> findShop(Long shopId);
}
