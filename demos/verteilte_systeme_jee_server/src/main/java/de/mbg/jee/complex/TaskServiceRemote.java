package de.mbg.jee.complex;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface TaskServiceRemote {

	public List<Task> getAllTasks();

	public Task getTask(int id);

	public void store(Task task);

	public void deleteTask(Task task);
}
