package umc.spring.apipayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.apipayload.code.BaseCode;
import umc.spring.apipayload.code.ReasonDTO;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {
    _OK("200", "OK", HttpStatus.OK),
    _CREATED("201", "CREATED", HttpStatus.CREATED),
    _ACCEPTED("202", "ACCEPTED", HttpStatus.ACCEPTED),
    _NON_AUTHORITATIVE_INFORMATION("203", "NON_AUTHORITATIVE_INFORMATION", HttpStatus.NON_AUTHORITATIVE_INFORMATION),
    _NO_CONTENT("204", "NO_CONTENT", HttpStatus.NO_CONTENT),
    _RESET_CONTENT("205", "RESET_CONTENT", HttpStatus.RESET_CONTENT),
    _PARTIAL_CONTENT("206", "PARTIAL_CONTENT", HttpStatus.PARTIAL_CONTENT),
    _MULTI_STATUS("207", "MULTI_STATUS", HttpStatus.MULTI_STATUS),
    _ALREADY_REPORTED("208", "ALREADY_REPORTED", HttpStatus.ALREADY_REPORTED),
    _IM_USED("226", "IM_USED", HttpStatus.IM_USED),
    ;

    private final String code;
    private final String message;
    private final HttpStatus httpStatus;


    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .code(code)
                .message(message)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .code(code)
                .message(message)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }
}
