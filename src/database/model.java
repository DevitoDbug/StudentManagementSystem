package database;

import java.util.ArrayList;

public class model {

	public String name;
	public String gender;
	public String year;
	public String age;
	public model(String name, String gender, String year, String age) {
		super();
		this.name = name;
		this.gender = gender;
		this.year = year;
		this.age = age;

	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "model{" +
				"name='" + name + '\'' +
				", gender='" + gender + '\'' +
				", year='" + year + '\'' +
				", age='" + age + '\'' +
				'}';
	}
}
