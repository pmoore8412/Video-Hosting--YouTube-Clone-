package org.clone.videohosting.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "That user all read exists")
public class UserAlreadyExistsException extends RuntimeException{
}
