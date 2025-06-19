package com.example.demo1;

public class ToDo {
	private static int count = 1;
	
	private final int id;
	private String title;
	private String status;

	
	public ToDo(String title) {
		this.id = count++;
		this.title = title;
		this.status = "未着手";
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

}
