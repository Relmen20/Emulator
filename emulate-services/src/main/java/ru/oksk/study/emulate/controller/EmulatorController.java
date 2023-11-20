package ru.oksk.study.emulate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.oksk.study.emulate.dto.EmulatorResponseDto;
import ru.oksk.study.emulate.dto.SMSDto;
import ru.oksk.study.emulate.model.ErrorType;
import ru.oksk.study.emulate.model.Status;
import ru.oksk.study.emulate.model.StatusType;
import ru.oksk.study.emulate.service.EmulatorService;
import ru.oksk.study.emulate.model.Error;

@RestController
@RequestMapping(path = "/api")
public class EmulatorController {

    private final EmulatorService emulatorService;

    @Autowired
    public EmulatorController(EmulatorService emulatorService) {
        this.emulatorService = emulatorService;
    }

    @PostMapping
    public EmulatorResponseDto startEmulatorPoint(@RequestBody SMSDto smsDto) {
        try {
            if (smsDto.getPhone() == null) {
                return new EmulatorResponseDto(new Status(StatusType.REJECTED),
                        new Error(ErrorType.INCORRECT_MOBILE_NUMBER));
            }
            return emulatorService.checkAvailability(smsDto);
        } catch (Exception e) {
            return null;
        }
    }
}
