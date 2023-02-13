package org.clone.videohosting.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "You already have a video uploaded with that title")
public class VideoAlreadyExistsException extends RuntimeException{
}
