package umc.spring.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;

public class ShopRequestDto {

    private ShopRequestDto() {
    }

    @Getter
    public static class CreateDto {
        @NotBlank
        String name;
        @NotBlank
        String address;
        @NotNull
        Long regionId;
    }
}
