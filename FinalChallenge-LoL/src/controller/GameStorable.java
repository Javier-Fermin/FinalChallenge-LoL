package controller;

import exceptions.PersonalizedException;
import model.Game;

public interface GameStorable {
	public void addGame(Game game) throws PersonalizedException;
	public Game searchGame(int id) throws PersonalizedException;
}