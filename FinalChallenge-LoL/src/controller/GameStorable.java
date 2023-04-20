package controller;

import model.Game;

public interface GameStorable {
	public void addGame(Game game);
	public Game searchGame(int id);
}