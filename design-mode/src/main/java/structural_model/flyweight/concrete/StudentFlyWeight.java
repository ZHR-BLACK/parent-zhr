package structural_model.flyweight.concrete;
/**
 * 使用了享元的学生类 
 * @author smilesnake
 *
 */
public class StudentFlyWeight extends Student{  
    public StudentFlyWeight(String name,int age,Academy academy){  
        this.name = name;  
        this.age = age;  
        this.academy = academy;  
    }  
    private String name;  
    private int age;  
    //学院bean  
    private Academy academy;  
      
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
    public String getAcademy() {  
        return academy.getAcademy();  
    }  
    public String getPresident() {  
        return academy.getPresident();  
    }  
    public String getPresidentSex() {  
        return academy.getPresidentSex();  
    }  
    public String getAcademyInfoInfo() {  
        return academy.getAcademyInfo();  
    }  
}
