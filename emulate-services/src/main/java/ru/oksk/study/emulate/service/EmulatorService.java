package ru.oksk.study.emulate.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.oksk.study.emulate.dto.EmulatorResponseDto;
import ru.oksk.study.emulate.dto.SMSDto;
import ru.oksk.study.emulate.model.Error;
import ru.oksk.study.emulate.model.*;

@Service
public class EmulatorService {

    private final static long MIN_PHONE_NUMBER = 80_000_000_000L;
    private final static long MAX_PHONE_NUMBER = 89_999_999_999L;
    @Value("${server.availabilityFactor}")
    private int availabilityFactor;

    public EmulatorResponseDto checkAvailability(SMSDto smsDto) {
        try {
            long phoneNumber = Long.parseLong(smsDto.getPhone());
            if (phoneNumber < MIN_PHONE_NUMBER || phoneNumber > MAX_PHONE_NUMBER) {
                return new EmulatorResponseDto(new Status(StatusType.REJECTED), new Error(ErrorType.INCORRECT_MOBILE_NUMBER));
            }
            boolean availability = (phoneNumber % availabilityFactor) == 0;
            if (availability) {
                return new EmulatorResponseDto(new Status(StatusType.DELIVERED));
            } else {
                return new EmulatorResponseDto(new Status(StatusType.UNDELIVERED), new Error(ErrorType.INCORRECT_MOBILE_NUMBER));
            }
        } catch (Exception e) {
            return new EmulatorResponseDto(new Status(StatusType.UNKNOWN), new Error(ErrorType.EXCEPTION, e));
        }
    }
}

