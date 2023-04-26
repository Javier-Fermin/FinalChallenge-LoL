package controller;

import java.util.Set;

import exceptions.PersonalizedException;
import model.Game;

public interface GameStorable {
	public int addGame(Game game) throws PersonalizedException;
	public Set<Game> searchGames(String nickname) throws PersonalizedException;
	public void completeGame(int id, String nickname, String name, boolean win, String position) throws PersonalizedException;
}