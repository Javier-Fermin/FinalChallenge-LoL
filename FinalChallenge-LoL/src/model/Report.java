package model;

// This is the Top Players class
public class Report {
	private String complainantNickname,reportedNickname,description,category,situation;
	private int id;

	private final String[] categories = {"TOP","JNG","MID","ADC","SUP"};

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

    public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReportedNickname() {
		return reportedNickname;
	}

	public void setReportedNickname(String reportedNickname) {
		this.reportedNickname = reportedNickname;
	}

	public String getComplainantNickname() {
		return complainantNickname;
	}

	public void setComplainantNickname(String complainantNickname) {
		this.complainantNickname = complainantNickname;
	}

	public String[] getCategories() {
		return categories;
	}

	public  void setId(int id) {
	 	this.id = id;
	}

	public int getId() {
		return id;
	}

}