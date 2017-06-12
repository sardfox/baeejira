package it.gruppostudio.baeejira.model;
// Generated 12-giu-2017 18.26.46 by Hibernate Tools 5.1.4.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Task generated by hbm2java
 */
@Entity
@Table(name = "task", catalog = "mydb")
public class Task implements java.io.Serializable {

	private TaskId id;
	private Project project;
	private Status status;
	private String name;
	private Date startDate;
	private Date endDate;
	private Set users = new HashSet(0);

	public Task() {
	}

	public Task(TaskId id, Project project, Status status) {
		this.id = id;
		this.project = project;
		this.status = status;
	}

	public Task(TaskId id, Project project, Status status, String name, Date startDate, Date endDate, Set users) {
		this.id = id;
		this.project = project;
		this.status = status;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.users = users;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
			@AttributeOverride(name = "projectId", column = @Column(name = "project_id", nullable = false)),
			@AttributeOverride(name = "statusId", column = @Column(name = "status_id", nullable = false)) })
	public TaskId getId() {
		return this.id;
	}

	public void setId(TaskId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", nullable = false, insertable = false, updatable = false)
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status_id", nullable = false, insertable = false, updatable = false)
	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date", length = 19)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", length = 19)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_has_task", catalog = "mydb", joinColumns = {
			@JoinColumn(name = "task_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "user_id", nullable = false, updatable = false) })
	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}
