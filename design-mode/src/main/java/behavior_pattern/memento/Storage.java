package behavior_pattern.memento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ZHR
 * @Description 用于存储备份数据类的类
 * @Date 2019/5/23 17:02
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {

	private Memento memento;

}
