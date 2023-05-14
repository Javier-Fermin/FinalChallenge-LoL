/**
 * The Game class represents a game played in the system. It contains information about the game,
	such as its ID, date and duration.
 * @author Javi
 * @version 1.0
 */
package model;

import java.time.LocalDate;

// This is the Game class
public class Game {
 /**
  * The ID of the game.
  */
 private int id;
 /**
  * The date of the game.
  */
 private LocalDate dateGame;
 /**
  * The duration of the game.
  */
 private Float duration;
 /**
  * Returns the ID of the game.
  * @return the ID of the game.
  */
public int getId() {
	return id;
}
/**
 * Sets the ID of the game.
 * @param i the ID of the game.
 */
public void setId(int i) {
	this.id = i;
}
/**
 * Returns the date of the game.
 * @return the date of the game.
 */
public LocalDate getDateGame() {
	return dateGame;
}
/**
 * Sets the date of the game.
 * @param dateGame the date of the game.
 */
public void setDateGame(LocalDate dateGame) {
	this.dateGame = dateGame;
}
/**
 * Returns the duration of the game.
 * @return the duration of the game.
 */
public Float getDuration() {
	return duration;
}
/**
 * Sets the duration of the game.
 * @param duration the duration of the game.
 */
public void setDuration(Float duration) {
	this.duration = duration;
}
}