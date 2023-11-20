package ru.oksk.study.emulate.dto;

import ru.oksk.study.emulate.model.Status;
import ru.oksk.study.emulate.model.Error;

public class EmulatorResponseDto {
    private Status status;
    private Error error;

    public EmulatorResponseDto() {
    }

    public EmulatorResponseDto(Status status) {
        this.error = new Error();
        this.status = status;
    }

    public EmulatorResponseDto(Status status, Error error) {
        this.error = error;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
