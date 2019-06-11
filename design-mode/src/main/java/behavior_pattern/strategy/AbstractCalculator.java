package behavior_pattern.strategy;

public abstract class AbstractCalculator {
	/**
	 * 分割出算式两边的数字
	 * @param exp 字符串式子
	 * @param opt +,-,*,/
	 * @return
	 */
	public int[] split(String exp,String opt){  
	        String array[] = exp.split(opt);  
	        int arrayInt[] = new int[2];  
	        arrayInt[0] = Integer.parseInt(array[0]);  
	        arrayInt[1] = Integer.parseInt(array[1]);  
	        return arrayInt;  
	    }  
}
