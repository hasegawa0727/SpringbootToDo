package com.example.demo1;

public class WrongIdException extends RuntimeException {
	public WrongIdException(long id) {
		super("指定されたIDのToDOは存在しません: " + id);
	}
}
