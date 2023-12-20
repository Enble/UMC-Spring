package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Review;
import umc.spring.domain.Shop;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findAllByShop(Shop shop, PageRequest pageRequest);
}
