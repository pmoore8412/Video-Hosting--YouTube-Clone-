package org.clone.videohosting.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "That user does not exist")
public class UserNotFoundException extends RuntimeException{
}
