/**
 * The User class represents a user of the system.
 * @author Irati
 * @author Alex
 * @version 1.0
 */
package model;

import java.time.LocalDate;
import java.time.Period;

// This is the User class
public class User {
	/**
	 * The ID of the user.
	 */
	private String id;
	/**
	 * The email of the user.
	 */
	private String email;
	/**
	 * The name of the user
	 */
	private String name;
	/**
	 * The birth date of the user
	 */
	private LocalDate birthDate;
	/**
	 * The phone of the user.
	 */
	private String phone;
	/**
	 * The nationality of the user
	 */
	private String nationality;
	/**
	 * The password of the user
	 */
	private String password;
	/**
	 * Returns the ID of the user.
	 * @return the ID of the user.
	 */
	public String getId() {
		return id;
	}
	/**
	 * Sets the ID of the user.
	 * @param id the ID of the user
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Returns the email of the user
	 * @return the email of the user.
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Sets the email of the user.
	 * @param email the email of the user
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Returns the name of the user
	 * @return the name of the user.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets the name of the user.
	 * @param name the name of the user
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Returns the birth date of the user
	 * @return the birth date of the user.
	 */
	public LocalDate getBirthDate() {
		return birthDate;
	}
	/**
	 * Sets the birth date of the user.
	 * @param birthDate the birth date of the user
	 */
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * Returns the phone of the user
	 * @return the phone of the user.
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * Sets the phone of the user.
	 * @param phone the phone of the user
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * Returns the naitonality of the user
	 * @return the nationality of the user.
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * Sets the naionality of the user.
	 * @param nationality the naionality of the user.
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	/**
	 * Returns the password of the user
	 * @return the password of the user.
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Sets the password of the user.
	 * @param password the password of the user
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Returns the age of the user by calculating the difference between the birth date and the current date.
	 * @return the age of the user.
	 */
	public int getEdad(){
		Period period = Period.between(birthDate, LocalDate.now());
		return period.getYears();
	}
}