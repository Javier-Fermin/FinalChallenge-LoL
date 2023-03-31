package model;

import java.time.LocalDate;

public class Game {
 private String id;
 private LocalDate dateGame;
 private Float duration;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public LocalDate getDateGame() {
	return dateGame;
}
public void setDateGame(LocalDate dateGame) {
	this.dateGame = dateGame;
}
public Float getDuration() {
	return duration;
}
public void setDuration(Float duration) {
	this.duration = duration;
}
}
