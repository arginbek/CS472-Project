package edu.mum.models;

public class ErrorMessage {
    private ErrorMessageType type;
    private String detail;

    public ErrorMessage(ErrorMessageType type, String detail) {
        super();
        this.type = type;
        this.detail = detail;
    }

    public ErrorMessageType getType() {
        return type;
    }

    public void setType(ErrorMessageType type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
