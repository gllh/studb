package Student;

/**
 * Created by Administrator on 2017/11/25.
 */

import java.io.Serializable;

public class Student implements Serializable{
	private long id;
	private String name;
	private int age;
	private String sex;
	private String major;
	public Student() {
		super();
	}
	public Student(long id, String name, int age, String sex,String major) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.major = major;
	}
	public Student(String name, int age, String sex,String major) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.major = major;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;     }
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMajor() {
		return major;     }
	public void setMajor(String major) {
		this.major = major;
	}
}