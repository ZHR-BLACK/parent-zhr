package structural_model.flyweight.concrete;
/**
 * 学院类 
 * @author smilesnake
 *
 */
public class Academy {
	public Academy(String academy, String president, String presidentSex, String academyInfo) {
		this.academy = academy;
		this.president = president;
		this.presidentSex = presidentSex;
		this.academyInfo = academyInfo;
	}

	// 学院名字
	private String academy;
	// 院长
	private String president;
	// 院长性别
	private String presidentSex;
	// 学院其他信息
	private String academyInfo;

	public final String getAcademy() {
		return academy;
	}

	public final void setAcademy(String academy) {
		this.academy = academy;
	}

	public final String getPresident() {
		return president;
	}

	public final void setPresident(String president) {
		this.president = president;
	}

	public final String getPresidentSex() {
		return presidentSex;
	}

	public final void setPresidentSex(String presidentSex) {
		this.presidentSex = presidentSex;
	}

	public final String getAcademyInfo() {
		return academyInfo;
	}

	public final void setAcademyInfo(String academyInfo) {
		this.academyInfo = academyInfo;
	}
}
