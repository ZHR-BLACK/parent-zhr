package behavior_pattern.memento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ZHR
 * @Description 用于备份原始数据的类
 * @Date 2019/5/23 16:58
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Memento {

    private String value;

}
