package org.clone.videohosting.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "You are not authorized to access this. " +
        "Please check your username and password or create an account")
public class UserNotAuthorizedException extends RuntimeException {

}
