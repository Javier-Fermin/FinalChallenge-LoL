package model;

import java.util.ArrayList;

public class Champ {
	private String name;
	private String region;
	private String passive;
	private String a;
	private String w;
	private String r;
	private String e;
	private String position;
	final String[] positions= {"TOP","JNG","MID","ADC","SUP"};
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPassive() {
		return passive;
	}
	public void setPassive(String passive) {
		this.passive = passive;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getW() {
		return w;
	}
	public void setW(String w) {
		this.w = w;
	}
	public String getR() {
		return r;
	}
	public void setR(String r) {
		this.r = r;
	}
	public String getE() {
		return e;
	}
	public void setE(String e) {
		this.e = e;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String[] getPositions() {
		return positions;
	}
	
}
