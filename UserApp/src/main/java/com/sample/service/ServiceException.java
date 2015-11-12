package com.sample.service;

/**
 * Created by hvaswani on 11/10/2015.
 * This is a ServiceException class that can be used by the service layer to throw
 * service-related exceptions.
 */
public class ServiceException extends Exception {
    /**
     * Constructor for a ServiceException
     * @param message - error message from the service layer
     */
    public ServiceException(String message) {
        super(message);
    }
}
