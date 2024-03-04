package de.mbg.jee.complex;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("tasks")
public class TaskRESTServiceFacade {

	@EJB
	private TaskServiceRemote _taskService;

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Task> getAllTasks() {
		return _taskService.getAllTasks();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("{id}")
	public Task getTask(@PathParam("id") int id) {
		return _taskService.getTask(id);
	}

}
