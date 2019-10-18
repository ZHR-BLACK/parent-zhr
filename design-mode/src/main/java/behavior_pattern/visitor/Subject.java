package behavior_pattern.visitor;

public interface Subject {

	void accept(Visitor visitor);
	
	String getSubject();
}
