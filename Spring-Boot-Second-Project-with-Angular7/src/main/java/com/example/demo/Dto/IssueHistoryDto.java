package com.example.demo.Dto;

import java.util.Date;

import com.example.demo.entity.IssueStatus;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import lombok.Data;

@ApiModel(value = "Issue History Data Transfer Object")
public class IssueHistoryDto {
    @ApiModelProperty(required = true,value = "ID")
    private Long id;
    @ApiModelProperty(required = true,value = "Issue")
    private IssueDto issue;
    @ApiModelProperty(required = true,value = "Descriptnon")
    private String description;
    @ApiModelProperty(required = true,value = "Date")
    private Date date;
    @ApiModelProperty(required = true,value = "Issue Status")
    private IssueStatus issueStatus;
    @ApiModelProperty(required = true,value = "Details")
    private String details;
    @ApiModelProperty(required = true,value = "Assignee")
    private UserDto assignee;
    
    
    
	public IssueHistoryDto() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public IssueDto getIssue() {
		return issue;
	}
	public void setIssue(IssueDto issue) {
		this.issue = issue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public IssueStatus getIssueStatus() {
		return issueStatus;
	}
	public void setIssueStatus(IssueStatus issueStatus) {
		this.issueStatus = issueStatus;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public UserDto getAssignee() {
		return assignee;
	}
	public void setAssignee(UserDto assignee) {
		this.assignee = assignee;
	}
    
    
    
}
