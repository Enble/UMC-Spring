package umc.spring.apipayload.exception.handler;

import umc.spring.apipayload.code.BaseErrorCode;
import umc.spring.apipayload.exception.GeneralException;

public class RegionHandler extends GeneralException {
    public RegionHandler(BaseErrorCode code) {
        super(code);
    }
}
