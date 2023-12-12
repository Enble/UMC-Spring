package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
