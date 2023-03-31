package controller;

import java.util.List;
import java.util.Set;

import model.Champ;

public interface ChampEditable {
	public void addChamp(Champ champ);
	public boolean modifyChamp (Champ champ);
	public List<Champ> listChamp();
	public List<Champ> listChamp(Set<String> filters);
}
