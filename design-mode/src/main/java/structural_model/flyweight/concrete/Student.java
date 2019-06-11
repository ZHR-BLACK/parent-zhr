package structural_model.flyweight.concrete;

/**
 * 学生类
 * 
 * @author smilesnake
 *
 */
public class Student {
	public Student() {
	}

	public Student(String name, int age, String academy, String president, String presidentSex, String academyInfo) {
		this.name = name;
		this.age = age;
		this.academy = academy;
		this.president = president;
		this.presidentSex = presidentSex;
		this.academyInfo = academyInfo;
	}

	private String name;
	private int age;
	// 所在学院president
	private String academy;
	// 院长
	private String president;
	// 院长性别
	private String presidentSex;
	// 学院其他信息
	private String academyInfo;

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getAcademy() {
		return academy;
	}

	public String getPresident() {
		return president;
	}

	public String getPresidentSex() {
		return presidentSex;
	}

	public String getAcademyInfoInfo() {
		return academyInfo;
	}
}
