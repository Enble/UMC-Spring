package umc.spring.apipayload.exception.handler;

import umc.spring.apipayload.code.BaseErrorCode;
import umc.spring.apipayload.exception.GeneralException;

public class ReviewHandler extends GeneralException {
    public ReviewHandler(BaseErrorCode code) {
        super(code);
    }
}
