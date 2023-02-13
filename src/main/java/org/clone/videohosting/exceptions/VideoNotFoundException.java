package org.clone.videohosting.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Video does not exist")
public class VideoNotFoundException extends RuntimeException {
}
