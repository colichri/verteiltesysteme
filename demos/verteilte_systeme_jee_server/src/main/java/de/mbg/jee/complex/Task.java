package de.mbg.jee.complex;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQuery(name = Task.TASK_QUERY_FULL, query = "select t from task as t")
@Entity(name = "task")
@Table(name = "task")
@XmlRootElement
public class Task implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String TASK_QUERY_FULL = "task_query_full";

	@Id
	// @GeneratedValue
	@Column(name = "task_id")
	private int id;

	@Column(name = "task_name")
	private String name;

	public Task() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + "]";
	}

}
