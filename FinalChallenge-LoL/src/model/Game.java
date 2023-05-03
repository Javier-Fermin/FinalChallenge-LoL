package model;

import java.time.LocalDate;

// This is the Game class
public class Game {
 private int id;
 private LocalDate dateGame;
 private Float duration;
public int getId() {
	return id;
}
public void setId(int i) {
	this.id = i;
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