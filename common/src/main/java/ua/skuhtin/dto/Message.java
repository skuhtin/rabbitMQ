package ua.skuhtin.dto;

import java.io.Serializable;

public class Message implements Serializable {

    private String message;
    private String description;

    public Message() {
    }

    public Message(String message, String description) {
        this.message = message;
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message1 = (Message) o;

        if (!message.equals(message1.message)) return false;
        return description.equals(message1.description);
    }

    @Override
    public int hashCode() {
        int result = message.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "OutPut Message{" +
                "message='" + message + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
