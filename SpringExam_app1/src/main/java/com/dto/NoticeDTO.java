package com.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("NoticeDTO")
public class NoticeDTO {
	
	int no;
	String title;
	String author;
	String content;
	Date writeday;
	int readcnt;
	public NoticeDTO() {
		// TODO Auto-generated constructor stub
	}
	public NoticeDTO(int no, String title, String author, String content, Date writeday, int readcnt) {
		this.no = no;
		this.title = title;
		this.author = author;
		this.content = content;
		this.writeday = writeday;
		this.readcnt = readcnt;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWriteday() {
		return writeday;
	}
	public void setWriteday(Date writeday) {
		this.writeday = writeday;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	@Override
	public String toString() {
		return "NoticeDTO [no=" + no + ", title=" + title + ", author=" + author + ", content=" + content
				+ ", writeday=" + writeday + ", readcnt=" + readcnt + "]";
	}
	
	

}
