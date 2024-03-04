package de.mbg.jee.client;

import java.util.List;

import javax.naming.InitialContext;

import de.mbg.jee.complex.Task;
import de.mbg.jee.complex.TaskServiceRemote;

public class ComplexEJBClient {
	public static void main(String[] args) throws Exception {
		String jndiName = "/04a_verteilte_systeme_jee_server/TaskServiceBean!de.mbg.jee.complex.TaskServiceRemote";
		InitialContext ctx = new InitialContext();
		TaskServiceRemote taskService = (TaskServiceRemote) ctx.lookup(jndiName);

		List<Task> tasks = taskService.getAllTasks();
		System.out.println(tasks);

		// Create new task...
//		 Task task = new Task();
//		 task.setId(4);
//		 task.setName("Test");
//		 taskService.store(task);

		// Delete task again...
//		 Task task = taskService.getTask(4);
//		 System.out.println(task);
//		 taskService.deleteTask(task);

		tasks = taskService.getAllTasks();
		System.out.println(tasks);

	}

}