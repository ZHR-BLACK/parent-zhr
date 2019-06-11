package behavior_pattern.memento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Original {

	private String value;

	/**
	 * @Author ZHR
	 * @Description 记录当前状态，做备份
	 * @Date 2019/5/23 17:03
	 * @return behavior_pattern.memento.Memento
	 **/
	public Memento createMemento(){
		return new Memento(value);
	}

	/**
	 * @Author ZHR
	 * @Description 从备份类中取出备份数据，恢复初始状态
	 * @Date 2019/5/23 17:04
	* @param: memento
	 * @return void
	 **/
	public void restoreMemento(Memento memento){
		this.value = memento.getValue();
	}
	
	
}
