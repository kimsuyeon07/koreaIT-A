package com.koreait.a.dto;

import java.sql.Date;


public class FReplyDTO {

	// field
	private long rn; 
	private long fno; // 댓글 No
	private long no;  // 게시판 No
	private String writer;
	private String content;
	private Date postdate;
	
	


	// Getter and Setter
	public long getRn() {
		return rn;
	}
	public void setRn(long rn) {
		this.rn = rn;
	}
	public long getFno() {
		return fno;
	}
	public void setFno(long fno) {
		this.fno = fno;
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	
	
	
}
