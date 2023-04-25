package controller;

import java.util.List;

import exceptions.PersonalizedException;
import model.Champ;

public interface ChampEditable {
	public void addChamp(Champ champ) throws PersonalizedException;
	public boolean modifyChamp (Champ champ) throws PersonalizedException;
	public List<Champ> listChamp() throws PersonalizedException;
	public List<Champ> listChamp(String filterPosition, String filterRegion) throws PersonalizedException;
}
