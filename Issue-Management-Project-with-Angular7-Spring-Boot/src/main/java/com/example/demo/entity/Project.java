package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project extends BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="project_code",unique=true)
	private String projectCode;
	
    @Column(name = "project_name", length = 300)
    private String projectName;

    @Column(name = "project_title", length = 300)
    private String projectTitle;
    
    @JoinColumn(name = "manager_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User manager;
	
	
	public Project() {
		super();
	}

	public Project(Long id, String projectCode, String projectName, User manager) {
		super();
		this.id = id;
		this.projectCode = projectCode;
		this.projectName = projectName;
		this.manager = manager;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public User getManager() {
		return manager;
	}


	public void setManager(User manager) {
		this.manager = manager;
	}
	
	
	
}
