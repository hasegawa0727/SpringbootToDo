package com.example.demo1;

import java.time.LocalDateTime;

public class ToDo {
	private static int count = 1;
	
	private final long id;
	private String title;
	private String status;
	private String description;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	
	public ToDo(String title, String description) {
		this.id = count++;
		this.title = title;
		this.status = "未着手";
		this.description = description;
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}
	
	public long getId() {
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

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}

/*以下Lombokでの定義
 * (パッケージ省略)
 * import lombok.Getter;
 * import lombock.Setter;
 * import lombok.NoArgsConstructor;
 * 
 * import java.time.LocalDateTime;
 * 
 * @Getter
 * @Setter
 * @NoArgsConstructor
 * public class ToDo {
 * 	private static int count = 1;
 * 
 * 	private final long id = count++;
 * 	private String title;
 * 	private String status = "未着手";
 * 	private String description;
 * 	private LocalDateTime createdAt = LocalDateTime.now();
 * 	private LocalDateTime updatedAt = LocalDateTime.now();
 *  
 * 	public ToDo(String title, String description) {
 * 		this.title = title;
 * 		this.description = description;
 *  }
 */ 