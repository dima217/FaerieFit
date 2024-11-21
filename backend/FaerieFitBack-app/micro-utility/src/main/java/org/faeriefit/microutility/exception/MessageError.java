package org.faeriefit.microutility.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageError {
    private String message;

    public MessageError(String message){
        this.message = message;
    }

    public static MessageError of(String message){
        return new MessageError(message);
    }
}
