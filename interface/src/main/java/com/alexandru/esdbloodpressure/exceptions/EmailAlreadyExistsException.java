package com.alexandru.esdbloodpressure.exceptions;

/**
 *
 * @author Alexandru Constantin <aconstantin@wincom-consulting.com>
 */
public class EmailAlreadyExistsException extends Throwable {

    public EmailAlreadyExistsException(final String message) {
        super(message);
    }
}
