package model;

public class Member {
	private String name;
	private int id;
	private int income;

	public Member(String name, int id, int income){
		this.name= name;
		this.id=id;
		this.income  = income;


	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}

	public String toString() {
		String s=this.name + " " + this.id;
		return s;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}
}
