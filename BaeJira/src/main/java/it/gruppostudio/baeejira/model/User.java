package it.gruppostudio.baeejira.model;
// Generated 16-giu-2017 11.17.12 by Hibernate Tools 5.1.4.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "mydb")
public class User implements java.io.Serializable {

	private Integer id;
	private String username;
	private String email;
	private String password;
	private Date createTime;
	private byte active;
	private Set<Project> projects = new HashSet<>(0);
	private Set<Task> tasks = new HashSet<>(0);
	private Set<Role> roles = new HashSet<>(0);

	public User() {
	}

	public User(String username, String email, String password, byte active) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.active = active;
	}

	public User(String username, String email, String password, Date createTime, byte active, Set<Project> projects, Set<Task> tasks,
			Set<Role> roles) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.createTime = createTime;
		this.active = active;
		this.projects = projects;
		this.tasks = tasks;
		this.roles = roles;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false, length = 16)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time", length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "active", nullable = false)
	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "project_has_user", catalog = "mydb", joinColumns = {
			@JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "project_id", nullable = false, updatable = false) })
	public Set<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_has_task", catalog = "mydb", joinColumns = {
			@JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "task_id", nullable = false, updatable = false) })
	public Set<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_has_role", catalog = "mydb", joinColumns = {
			@JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "role_id", nullable = false, updatable = false) })
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, username=%s, email=%s, password=%s, createTime=%s, active=%s, roles=%s]", id,
				username, email, password, createTime, active, roles);
	}

}
