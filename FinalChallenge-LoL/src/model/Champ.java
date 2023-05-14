/**
 * The champ class represents a champion in the system
 * @author Iñigo
 * @version 1.0
 */
package model;

// This is the Champ class
public class Champ {
	/**
	 * The name of the champion.
	 */
	private String name;
	/**
	 * The region of the champion.
	 */
	private String region;
	/**
	 * The passive of the champion.
	 */
	private String passive;
	/**
	 * The Q ability of the champion.
	 */
	private String q;
	/**
	 * The W ability of the champion.
	 */
	private String w;
	/**
	 * The E ability of the champion.
	 */
	private String r;
	/**
	 * The R ability of the champion.
	 */
	private String e;
	/**
	 * The position of the champion.
	 */
	private String position;
	/**
	 * The array of positions of the champion.
	 */
	private final String[] positions= {"TOP","JNG","MID","ADC","SUP"};

	/**
 	* Get the name of the champion.
 	* 
 	* @return the name of the champion.
 	*/
	public String getName() {
		return name;
	}
	/**
 	* Set the name of the champion.
 	* 
 	* @param name the name of the champion.
 	*/
	public void setName(String name) {
		this.name = name;
	}
	/**
 	* Get the region of the champion.
 	* 
 	* @return the region of the champion.
 	*/
	public String getRegion() {
		return region;
	}
	/**
 	* Set the region of the champion.
 	* 
 	* @param region the region of the champion.
 	*/
	public void setRegion(String region) {
		this.region = region;
	}
	/**
 	* Get the passive of the champion.
 	* 
 	* @return the passive of the champion.
 	*/
	public String getPassive() {
		return passive;
	}
	/**
 	* Set the passive of the champion.
 	* 
 	* @param passive the passive of the champion.
 	*/
	public void setPassive(String passive) {
		this.passive = passive;
	}
	/**
 	* Get the q of the champion.
 	* 
 	* @return the q of the champion.
 	*/
	public String getQ() {
		return q;
	}
	/**
 	* Set the q of the champion.
 	* 
 	* @param q the q of the champion.
 	*/
	public void setQ(String q) {
		this.q = q;
	}
	/**
 	* Get the w of the champion.
 	* 
 	* @return the w of the champion.
 	*/
	public String getW() {
		return w;
	}
	/**
 	* Set the w of the champion.
 	* 
 	* @param w the w of the champion.
 	*/
	public void setW(String w) {
		this.w = w;
	}
	/**
 	* Get the r of the champion.
 	* 
 	* @return the r of the champion.
 	*/
	public String getR() {
		return r;
	}
	/**
 	* Set the r of the champion.
 	* 
 	* @param r the r of the champion.
 	*/
	public void setR(String r) {
		this.r = r;
	}
	/**
 	* Get the e of the champion.
 	* 
 	* @return the e of the champion.
 	*/
	public String getE() {
		return e;
	}
	/**
 	* Set the e of the champion.
 	* 
 	* @param e the e of the champion.
 	*/
	public void setE(String e) {
		this.e = e;
	}
	/**
 	* Get the position of the champion.
 	* 
 	* @return the position of the champion.
 	*/
	public String getPosition() {
		return position;
	}
	/**
 	* Set the position of the champion.
 	* 
 	* @param position the position of the champion.
 	*/
	public void setPosition(String position) {
		this.position = position;
	}
	/**
 	* Get the positions of the champion.
 	* 
 	* @return the positions of the champion.
 	*/
	public String[] getPositions() {
		return positions;
	}
	
}
