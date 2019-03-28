package com.example.demo.Dto;

import java.util.Date;

import com.example.demo.entity.IssueStatus;
import com.example.demo.entity.Project;
import com.example.demo.entity.User;

import lombok.Data;

@Data
public class IssueDto {

	private Long id;
	private String description;
	private String details;
	private Date date;
	private IssueStatus issueStatus;
	private UserDto assignee;
	private ProjectDto project;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
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
	public UserDto getAssignee() {
		return assignee;
	}
	public void setAssignee(UserDto assignee) {
		this.assignee = assignee;
	}
	public ProjectDto getProject() {
		return project;
	}
	public void setProject(ProjectDto project) {
		this.project = project;
	}
	
	
	
	
}
