/**
* The Administrator class represents an administrator user in the system. This class
* extends from the User class.
* @author Irati
* @author Alex
* @version 1.0
*/

package model;

import java.time.LocalDate;
import java.time.Period;

// This is the Administrator class, which extends from User 
public class Administrator extends User {
	/**
	 * The number of additions made by the administrator.
	 */
	private int addtions;
	/**
	 * The date when the administrator started working.
	 */
	private LocalDate startDate;

	/**
 	* Get the number of additions made by the administrator.
 	* 
 	* @return the number of additions made by the administrator.
 	*/
	public int getAddtions() {
		return addtions;
	}

	/**
 	* Set the number of additions made by the administrator.
 	* 
 	* @param addtions the number of additions made by the administrator.
 	*/
	public void setAddtions(int addtions) {
		this.addtions = addtions;
	}

	/**
 	* Get the date when the administrator started working.
 	* 
 	* @return the date when the administrator started working.
 	*/
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
 	* Set the date when the administrator started working.
 	* 
 	* @param startDate the date when the administrator started working.
 	*/
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	
	/**
 	* Get the number of years the administrator has been working.
 	* 
 	* @return the number of years the administrator has been working.
 	*/
	public int getAntiguedad() {
		Period period = Period.between(startDate, LocalDate.now());
		return period.getYears();
		
	}
}
