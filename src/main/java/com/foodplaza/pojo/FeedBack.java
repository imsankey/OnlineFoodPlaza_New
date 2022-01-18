package com.foodplaza.pojo;

public class FeedBack 
{
	private int feedbackId;
	private String feedback,customername,emailId,rview;
	public FeedBack(String customername, String emailId, String feedback, String rview) {
		super();
		
		this.feedback = feedback;
		this.customername = customername;
		this.emailId = emailId;
		this.rview = rview;
	}
	public FeedBack() {
		// TODO Auto-generated constructor stub
	}
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getRview() {
		return rview;
	}
	public void setRview(String rview) {
		this.rview = rview;
	}
	@Override
	public String toString() {
		return "FeedBack [feedbackId=" + feedbackId + ", feedback=" + feedback + ", customername=" + customername
				+ ", emailId=" + emailId + ", rview=" + rview + "]";
	}
	
	
	

}
