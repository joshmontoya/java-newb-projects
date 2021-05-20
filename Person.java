package montoyaClasses;

public class Person {

	private String firstName;
	private String lastName;
	private int age;
	
	public Person() {
		this.firstName = "John";
		this.lastName = "Nitya";
		this.age = 31;
	}
	
	public Person(String inputFirstName, String inputLastName, int age) {
		this.firstName = inputFirstName;
		this.lastName = inputLastName;
		this.age = age;
	}

//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//	
	public void dispAttr() {
		System.out.println(this.firstName + " " + this.lastName + ", age: " + this.age);
	}

}
