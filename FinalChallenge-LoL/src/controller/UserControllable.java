package controller;

import java.util.Set;

import exceptions.PersonalizedException;
import model.Administrator;
import model.Player;
import model.User;
import model.Report;

/**
 * UserControllable interface that manages everything related to adding, finding, modifying and deleting Users
 * @author Irati Garzón
 * @author Alex Salinero
 *
 */
public interface UserControllable {
	/**
	 * Method use to check if the information related to the logIn is correct
	 * 
	 * @param usr user to be checked
	 * @param passwd password to be checked
	 * @return true if the user exists, false otherwise
	 * @throws PersonalizedException if there is an error logging in
	 */
	public boolean logIn(String usr, String passwd) throws PersonalizedException;

	/**
	 * Method in charge of deleting a User
	 * @param user user to be deleted
	 * @param chooseConnection connection to be used
	 * @return true if the user has been deleted, false otherwise
	 * @throws PersonalizedException if there is an error deleting the user
	 */
	public boolean delete(User user, int chooseConnection) throws PersonalizedException;

	/**
	 * Method used to look for a certain User
	 * 
	 * @param usr user to be looked for
	 * @param chooseConnection connection to be used
	 * @return the user if it exists
	 * @throws PersonalizedException if there is an error looking for the user
	 */
	public User findUser(String usr, int chooseConnection) throws PersonalizedException;

	/**
	 * Method used to add a User
	 * 
	 * @param user user to be added
	 * @param chooseConnection connection to be used
	 * @throws PersonalizedException if there is an error adding the user
	 */
	public void addUser(User user, int chooseConnection) throws PersonalizedException;

	/**
	 * Method responsible of modifications to a User
	 * @param user user to be modified
	 * @param chooseConnection connection to be used
	 * @return true if the user has been modified, false otherwise
	 * @throws PersonalizedException if there is an error modifying the user
	 */
	public boolean modifyUser(User user, int chooseConnection) throws PersonalizedException;

	/**
	 * Method that lists the existing Players
	 * @return a set of players
	 * @throws PersonalizedException if there is an error obtaining the players
	 */
	public Set<User> listPlayers() throws PersonalizedException;
	/**
	 * Method that inserts a new Report
	 * @param report report to be inserted
	 * @return true if the report has been inserted, false otherwise
	 * @throws PersonalizedException if there is an error inserting the report
	 */
	public boolean insertReport(Report report) throws PersonalizedException;

	/**
	 * Method that lists the existing reports
	 * @return a set of reports
	 * @throws PersonalizedException if there is an error obtaining the reports
	 */
	public Set<Report> listReports() throws PersonalizedException;

	/**
	 * Method that resolves a report by updating its status
	 * @param report report to be resolved
	 * @return true if the report has been resolved, false otherwise
	 * @throws PersonalizedException if there is an error resolving the report
	 */
	public boolean resolveReport(Report report) throws PersonalizedException;
}
