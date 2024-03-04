package com.mbg.rest.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient {
	private static String baseURL = "http://localhost:8090/rest/user-service";

	public static void readUser(int id) {
		String url = baseURL + "/user/" + id;
		System.out.println("Calling url=" + url);
		Client client = ClientBuilder.newClient();
		Response response = client.target(url).request(MediaType.APPLICATION_XML).get();
		String user = response.readEntity(String.class);
//		User user = response.readEntity(User.class);
		System.out.println("User: " + user);
	}

	public static void readAllUsers() {
		String url = baseURL + "/all";
		System.out.println("Calling url=" + url);
		Client client = ClientBuilder.newClient();
		Response response = client.target(url).request(MediaType.APPLICATION_XML).get();
		String userList = response.readEntity(String.class);
//		List<Users> userList = response.readEntity(new GenericType<List<User>>() {});
		System.out.println("All Users: " + userList);
	}

	public static void addUser() {
		String url = baseURL + "/user/add";
		System.out.println("Calling url=" + url);
		Client client = ClientBuilder.newClient();
		User user = new User(-1, "tt", "Test", "User");
		Response response = client.target(url).request(MediaType.APPLICATION_XML)
				.post(Entity.entity(user, MediaType.APPLICATION_XML));
		User userResult = response.readEntity(User.class);
		System.out.println("User added: " + userResult);
	}

	public static void deleteUser(int id) {
		String url = baseURL + "/user/" + id;
		System.out.println("Calling url=" + url);
		Client client = ClientBuilder.newClient();
		Response response = client.target(url).request(MediaType.APPLICATION_XML).delete();
		User user = response.readEntity(User.class);
		System.out.println("User deleted: " + user);
	}

	public static void main(String[] args) {
		readAllUsers();
//		readUser(1);
//		deleteUser(5);
//		addUser();
//		readAllUsers();
	}
}