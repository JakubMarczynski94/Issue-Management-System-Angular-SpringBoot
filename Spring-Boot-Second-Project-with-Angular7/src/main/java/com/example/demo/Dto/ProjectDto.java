package com.example.demo.Dto;

import javax.validation.constraints.NotNull;

public class ProjectDto {
	private Long id;
	
	@NotNull
	private String projectName;
	@NotNull
	private	String projectCode;

	public ProjectDto() {
		super();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	
	
	
}
