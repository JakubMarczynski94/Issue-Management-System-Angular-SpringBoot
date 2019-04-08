package com.example.demo.Dto;

import javax.validation.constraints.NotNull;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import lombok.Data;


@Data
@ApiModel(value="Project Data Transfer Object")
public class ProjectDto {
	

	@ApiModelProperty(value=" ProjectDto ID")
	private Long id;
	
	@NotNull
	@ApiModelProperty(required=true,value=" Name of ProjectDto ")
	private String projectName;
	@NotNull
	@ApiModelProperty(required=true,value=" Code of ProjectDto ")
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
