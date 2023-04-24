package controller;

import model.Administrator;
import model.Player;
import model.User;

public interface UserControllable {
	public boolean logIn (String usr, String passwd);
	public boolean delete (User user);
	public User findUser (String usr);
	public void addUser (User user);
	public boolean modifyUser (User user);
}
