package umc.spring.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import umc.spring.domain.FoodCategory;
import umc.spring.repository.FoodCategoryRepository;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public void run(ApplicationArguments args) {
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
    }

}
