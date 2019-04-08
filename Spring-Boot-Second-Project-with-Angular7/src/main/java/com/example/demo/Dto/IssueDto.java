package com.example.demo.Dto;

import java.util.Date;

import com.example.demo.entity.IssueStatus;
import com.example.demo.entity.Project;
import com.example.demo.entity.User;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import lombok.Data;

@Data
@ApiModel(value="Issue Data Transfer Object")
public class IssueDto {

	@ApiModelProperty(required=true,value=" id of IssueDto ")
	private Long id;
	@ApiModelProperty(required=true,value=" description of IssueDto ")
	private String description;
	@ApiModelProperty(required=true,value=" details of IssueDto ")
	private String details;
	@ApiModelProperty(required=true,value=" date")
	private Date date;
	@ApiModelProperty(required=true,value=" issueStatus")
	private IssueStatus issueStatus;
	@ApiModelProperty(required=true,value=" assignee")
	private UserDto assignee;
	@ApiModelProperty(required=true,value=" project")
	private ProjectDto project;
	
	
	
	public IssueDto() {
		super();
	}
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
