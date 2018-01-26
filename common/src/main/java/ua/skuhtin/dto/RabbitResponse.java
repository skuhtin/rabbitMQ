package ua.skuhtin.dto;

import java.io.Serializable;

public class RabbitResponse implements Serializable {
    String message;

    public RabbitResponse() {
    }

    public RabbitResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
