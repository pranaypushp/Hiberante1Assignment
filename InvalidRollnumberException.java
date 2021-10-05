package com.te.hibernate.assignment1;

public class InvalidRollnumberException extends RuntimeException {
String msg;


public InvalidRollnumberException(String msg) {
	this.msg = msg;
}

public String getMessage() {
	
	return this.msg;
}
}
