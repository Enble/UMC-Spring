package umc.spring.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Member;
import umc.spring.domain.Region;
import umc.spring.domain.enums.Gender;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.RegionRepository;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final FoodCategoryRepository foodCategoryRepository;

    private final RegionRepository regionRepository;
    private final MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) {
        // 음식 카테고리 초기화
        foodCategoryRepository.save(FoodCategory.builder()
                .name("한식")
                .build());
        foodCategoryRepository.save(FoodCategory.builder()
                .name("양식")
                .build());
        foodCategoryRepository.save(FoodCategory.builder()
                .name("중식")
                .build());
        foodCategoryRepository.save(FoodCategory.builder()
                .name("일식")
                .build());

        // 지역 초기화
        regionRepository.save(Region.builder()
                .name("서울")
                .build());
        regionRepository.save(Region.builder()
                .name("경기")
                .build());
        regionRepository.save(Region.builder()
                .name("인천")
                .build());
        regionRepository.save(Region.builder()
                .name("부산")
                .build());
    }

}
