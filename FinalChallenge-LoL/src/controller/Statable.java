package controller;

import java.util.Set;

import exceptions.PersonalizedException;
import model.Played;

public interface Statable {
	public Set <Played> stadistics (String nickname) throws PersonalizedException;
}
