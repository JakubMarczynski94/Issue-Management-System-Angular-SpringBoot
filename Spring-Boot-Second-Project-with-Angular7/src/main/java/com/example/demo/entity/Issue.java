package com.example.demo.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="issue")
public class Issue extends BaseEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="description",length=1000)
	private String description;
	
	@Column(name="details",length=4000)
	private String details;
	
	@Column(name="date",length=400)
	private Date date;
	
	@Column(name="issue_status")
	@Enumerated(EnumType.STRING)
	private IssueStatus issueStatus;
	
	@JoinColumn(name="assignee_user_id")
	@ManyToOne(optional=true,fetch=FetchType.LAZY)
	private User assignee;
	
    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Project project;
	
	public Issue() {
		super();
	}
	



	public Issue(Long id, String description, String details, Date date, IssueStatus issueStatus, User assignee,
			Project project) {
		super();
		this.id = id;
		this.description = description;
		this.details = details;
		this.date = date;
		this.issueStatus = issueStatus;
		this.assignee = assignee;
		this.project = project;
	}




	public Project getProject() {
		return project;
	}




	public void setProject(Project project) {
		this.project = project;
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

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assignee == null) ? 0 : assignee.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((issueStatus == null) ? 0 : issueStatus.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Issue other = (Issue) obj;
		if (assignee == null) {
			if (other.assignee != null)
				return false;
		} else if (!assignee.equals(other.assignee))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (issueStatus != other.issueStatus)
			return false;
		return true;
	}
	
	
	
	
	
}
