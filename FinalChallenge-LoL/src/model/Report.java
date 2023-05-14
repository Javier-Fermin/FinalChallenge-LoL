/**
 * This class represents a report made by a player about another player
 * @author Iñigo
 * @version 1.0
 */
package model;

// This is the Top Players class
public class Report {
	/**
	 * The nickname of the player who made the report.
	 */
	private String complainantNickname;
	/**
	 * The nickname of the player who is reported.
	 */
	private String reportedNickname;
	/**
	 * The description of the report.
	 */
	private String description;
	/**
	 * The category of the report.
	 */
	private String category;
	/**
	 * The situation of the report.
	 */
	private String situation;
	/**
	 * The ID of the report.
	 */
	private int id;

	/**
 	* Returns the situation of the report.
 	* @return a string representing the situation of the report
 	*/
	public String getSituation() {
		return situation;
	}
	/**
 	* Sets the situation of the report.
 	* @param situation a string representing the situation of the report
 	*/
	public void setSituation(String situation) {
		this.situation = situation;
	}
	/**
	 * Returns the category of the report.
	 * @return a string representing the category of the report
	 */
    public String getCategory() {
		return category;
	}

	/**
	 * Sets the category of the report
	 * @param category a string representing the category of the report
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Returns the description of the report.
	 * @return a string representing the description of the report
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description of the repor
	 * @param description a string representing the description of the report
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the nickname of the player who is reported
	 * @return a string representing the nickname of the player who is reported
	 */
	public String getReportedNickname() {
		return reportedNickname;
	}

	/**
	 * Sets the nickname of the player who is reported.
	 * @param reportedNickname a string representing the nickname of the player who is reported
	 */
	public void setReportedNickname(String reportedNickname) {
		this.reportedNickname = reportedNickname;
	}

	/**
	 * Returns the nickname of the player who made the report.
	 * @return a string representing the nickname of the player who made the report
	 */
	public String getComplainantNickname() {
		return complainantNickname;
	}

	/**
	 * Sets the nickname of the player who made the report.
	 * @param complainantNickname a string representing the nickname of the player who made the report
	 */
	public void setComplainantNickname(String complainantNickname) {
		this.complainantNickname = complainantNickname;
	}

	/**
	 * Returns the ID of the report.
	 * @return an integer representing the ID of the report
	 */
	public  void setId(int id) {
	 	this.id = id;
	}

	/**
	 * Sets the ID of the report.
	 * @param id an integer representing the ID of the report
	 */
	public int getId() {
		return id;
	}

}