package com.alexandru.esdbloodpressure.exceptions;

/**
 *
 * @author Alexandru Constantin <aconstantin@wincom-consulting.com>
 */
public class UserAlreadyExistsException extends Throwable {

    public UserAlreadyExistsException(final String message) {
        super(message);
    }
}
