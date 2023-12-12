package umc.spring.web.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apipayload.ApiResponse;
import umc.spring.converter.ShopConverter;
import umc.spring.domain.Shop;
import umc.spring.service.shop_service.ShopCommandService;
import umc.spring.web.dto.shop.ShopRequestDto;
import umc.spring.web.dto.shop.ShopResponseDto;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/shops")
public class ShopRestController {

    private final ShopCommandService shopCommandService;

    @PostMapping("/")
    public ApiResponse<ShopResponseDto.CreateResultDto> create(@RequestBody @Valid ShopRequestDto.CreateDto request) {
        Shop shop = shopCommandService.createShop(request);
        return ApiResponse.onSuccess(ShopConverter.toCreateResultDto(shop));
    }
}
