package behavior_pattern.observer;

import java.util.Observable;
import java.util.Observer;
/**
 * 观察者
 * @author smilesnake
 *
 */
public class TaoBaoObserver implements Observer{

	@Override
	public void update(Observable o, Object product) {
		String newProduct = (String) product;
		System.err.println("发送新产品【"+newProduct+"】同步到淘宝商场");
	}

}
