package de.mbg.jee.complex;

import java.util.List;

import javax.persistence.EntityManager;

public class TaskDAO {

	private EntityManager _entityManager;

	public TaskDAO(EntityManager em) {
		_entityManager = em;
	}

	public List<Task> getAllTasks() {
		return _entityManager
				.createNamedQuery(Task.TASK_QUERY_FULL, Task.class)
				// .createQuery("select t from task as t", Task.class)
				.getResultList();
	}

	public Task getTask(int id) {
		return _entityManager
				.createQuery("select t from task as t where task_id = :taskID",
						Task.class).setParameter("taskID", id)
				.getSingleResult();
	}

	public void store(Task task) {
		_entityManager.persist(task);
	}

	public void delete(Task task) {
		Task dbTask = getTask(task.getId());
		_entityManager.remove(dbTask);
	}
}
