package umc.spring.service.shop;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Shop;
import umc.spring.repository.ShopRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShopQueryServiceImpl implements ShopQueryService {

    private final ShopRepository shopRepository;

    @Override
    public Optional<Shop> findShop(Long shopId) {
        return shopRepository.findById(shopId);
    }
}
