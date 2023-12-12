package umc.spring.web.dto.shop;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ShopResponseDto {

    private ShopResponseDto() {
    }

    @Builder
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    public static class CreateResultDto {
        Long shopId;
        LocalDateTime createdAt;
    }
}
