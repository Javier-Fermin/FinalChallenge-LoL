package controller;

import java.util.Set;

import exceptions.PersonalizedException;
import model.Administrator;
import model.Player;
import model.User;

public interface UserControllable {
	public boolean logIn (String usr, String passwd) throws PersonalizedException;
	public boolean delete (User user) throws PersonalizedException;
	public User findUser (String usr) throws PersonalizedException;
	public void addUser (User user) throws PersonalizedException;
	public boolean modifyUser (User user) throws PersonalizedException;
	public Set<User> listPlayers()  throws PersonalizedException;
}
