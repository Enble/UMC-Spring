package umc.spring.validation.validator;

import java.util.Optional;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.domain.Shop;
import umc.spring.service.shop.ShopQueryService;
import umc.spring.validation.annotation.ExistShop;

@Component
@RequiredArgsConstructor
public class ShopExistValidator implements ConstraintValidator<ExistShop, Long> {

    private final ShopQueryService shopQueryService;

    @Override
    public void initialize(ExistShop constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Optional<Shop> shop = shopQueryService.findShop(value);

        if (shop.isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.SHOP_NOT_FOUND.toString())
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
