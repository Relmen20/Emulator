package ru.oksk.study.emulate.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class SMSDto {
    @Null
    private String id;
    @NotNull
    @NotBlank
    private String phone;
    @NotNull
    private String originatorId;
    @NotNull
    @NotBlank
    private String text;
    @NotNull
    @NotBlank
    private String sessionName;

    public SMSDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOriginatorId() {
        return originatorId;
    }

    public void setOriginatorId(String originatorId) {
        this.originatorId = originatorId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    @Override
    public String toString() {
        return "ClientMessageDto{" +
                "id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", originatorId=" + originatorId +
                ", text='" + text + '\'' +
                ", sessionName='" + sessionName + '\'' +
                '}';
    }
}
