package com.mbg.rest.server;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("user-service")
public class RestUserService {
	public static List<User> userList = new ArrayList<User>();

	static {
		userList.add(new User(getNextID(), "mm", "Max", "Mayer"));
		userList.add(new User(getNextID(), "xs", "Xaver", "Schmidt"));
		userList.add(new User(getNextID(), "pm", "Petra", "Müller"));
		userList.add(new User(getNextID(), "es", "Emil", "Schmitt"));
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("all")
	public List<User> getAllUsers() {
		System.out.println("RestUserService.all... called.");
		return userList;
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("user/{id}")
	public User getUser(@PathParam("id") int id) {
		System.out.println("RestUserService.user/id... called.");
//		System.out.println(userList);
		for (User user : userList) {
			if (user.getId() == id) {
				System.out.println("return " + user);
				return user;
			}
		}
		return null;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	@Path("add")
	public User addUser(@QueryParam("shortName") String shortName, @QueryParam("firstName") String firstName,
			@QueryParam("lastName") String lastName) {
		System.out.println("RestUserService.add... called.");
		User user = new User(getNextID(), shortName, firstName, lastName);
		userList.add(user);
		return user;
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	@Path("/user/add")
	public User addUser(User userParam) {
		System.out.println("RestUserService.add with User... called.");
		User user = new User(getNextID(), userParam.getShortName(), userParam.getFirstName(), userParam.getLastName());
		userList.add(user);
		return user;
	}

	@DELETE
	// @Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	@Path("user/{id}")
	public User deleteUser(@PathParam("id") int id) {
		System.out.println("RestUserService.delete... called.");
		User userToBeDeleted = null;
		for (User user : userList) {
			if (user.getId() == id) {
				userToBeDeleted = user;
			}
		}
		userList.remove(userToBeDeleted);
		return userToBeDeleted;
	}

	private static int getNextID() {
		int max = 0;
		for (User user : userList) {
			if (user.getId() > max) {
				max = user.getId();
			}
		}
		return max + 1;
	}
}
