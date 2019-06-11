package behavior_pattern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
/**
 * 被观察者
 * @author smilesnake
 *
 */
public class ProductList extends Observable {
	private List<String> productList = null;
	
	private static ProductList instance;

	private ProductList() {} //构造方法私有化
	
	/**
	 * 取得唯一实例
	 * @return 产品列表唯一实例
	 */
	public static ProductList getInstance(){
		if(instance == null){
			instance = new ProductList();
			instance.productList = new ArrayList<String>();
		}
		return instance;
	}
	/**
	 * 增加观察者
	 * @param observer 观察者
	 */
	public void addProductListObserver(Observer observer){
		this.addObserver(observer);
	}
	
	/**
	 * 新增产品
	 * @param newProject 新产品
	 */
	public void addProduct(String newProduct){
		productList.add(newProduct);
		System.out.println("产品列表新增了产品:"+newProduct);
		this.setChanged();  //设置被观察者对象发生变化
		this.notifyObservers(newProduct); //通知观察者，并传递新产品
	}
	
	public static void main(String[] args) {
		ProductList observable = ProductList.getInstance();
		TaoBaoObserver taoBaoObserver = new TaoBaoObserver();
		JingDongObserver dongObserver = new JingDongObserver();
		observable.addObserver(taoBaoObserver);
		observable.addObserver(dongObserver);
		observable.addProduct("新增产品1");
	}
	
}
