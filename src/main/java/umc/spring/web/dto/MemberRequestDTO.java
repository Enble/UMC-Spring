package umc.spring.web.dto;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Value;
import umc.spring.domain.Address;
import umc.spring.validation.annotation.ExistCategories;

@Value
public class MemberRequestDTO {

    @Getter
    public static class JoinDTO {
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotNull
        LocalDate birthday;
        @NotNull
        Address address;
        @Size(min = 5, max = 12)
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }

}
