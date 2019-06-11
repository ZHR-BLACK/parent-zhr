package creation_pattern.sington;

import java.util.Vector;

/**
 * 采用"影子实例"的办法为单例对象的属性同步更新
 * @author smilesnake
 *
 */
public class SingletonTest {
	private static SingletonTest instance = null;
	/**
	 * <p>Vector不需顾及类型也不需预先选定向量的容量，</p>
	 * <p>并可以方便地进行查找。对于预先不知或者不愿预先定义数组大小，</p>
	 * <p>并且需要频繁地进行查找，插入，删除工作的情况,可以先考虑Vector</p>
	 * <p>随机访问速度快，插入和移除性能较差(数组的特点)；支持null元素；</p>
	 * <p>有顺序；元素可以重复；线程安全；</p>
	 */
	private Vector properties =null;
	
	public Vector getProperties(){
		return properties;
	}	
	
	private SingletonTest() {
	}

	private static synchronized void syncInit() {
		if (instance == null)
			instance = new SingletonTest();
	}

	public static SingletonTest getInstance() {
		if (instance == null)
			syncInit();
		
		return instance;
	}
	
	public void updateProperties(){
		SingletonTest shadow = new SingletonTest();
		properties = shadow.getProperties();
	}
}

