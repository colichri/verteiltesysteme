package de.mbg.jee.complex;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;

/**
 * Session Bean implementation class TestBean
 */
@Stateless
@WebService
public class TaskServiceBean implements TaskServiceRemote {

	@PersistenceContext(unitName = "tasksystem")
	private EntityManager _entityManager;

	@WebMethod
	@GET
	public List<Task> getAllTasks() {
		TaskDAO dao = new TaskDAO(_entityManager);
		return dao.getAllTasks();
	}

	@WebMethod
	public Task getTask(@WebParam(name = "id") int id) {
		TaskDAO dao = new TaskDAO(_entityManager);
		return dao.getTask(id);
	}

	@WebMethod
	public void store(Task task) {
		TaskDAO dao = new TaskDAO(_entityManager);
		dao.store(task);
	}

	@WebMethod
	public void deleteTask(Task task) {
		TaskDAO dao = new TaskDAO(_entityManager);
		dao.delete(task);
	}
}
