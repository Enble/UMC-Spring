package umc.spring.apipayload.exception.handler;

import umc.spring.apipayload.code.BaseErrorCode;
import umc.spring.apipayload.exception.GeneralException;

public class ShopHandler extends GeneralException {
    public ShopHandler(BaseErrorCode code) {
        super(code);
    }
}
