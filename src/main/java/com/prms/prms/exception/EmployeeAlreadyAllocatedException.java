package com.prms.prms.exception;
public class EmployeeAlreadyAllocatedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
    public EmployeeAlreadyAllocatedException(String message) {
        super(message);
    }
}
