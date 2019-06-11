package behavior_pattern.template_method;

public class Minus extends AbstractCalculator{

	@Override
	public int calculate(int num1, int num2) {
		return num1-num2;
	}
	
}
