package behavior_pattern.iterator;


/**
 * <p>迭代子模式（Iterator）
 * <p>迭代器模式就是顺序访问聚集中的对象，一般来说，集合中非常常见，
 * <p>如果对集合类比较熟悉的话，理解本模式会十分轻松。这句话包含两层意思：
 * <p>一是需要遍历的对象，即聚集对象
 * <p>二是迭代器对象，用于对聚集对象进行遍历访问。
 * @author smilesnake
 *
 */
public interface Collection {
	Iterator iterator();
	/**
	 * 取得集合元素
	 * @param i
	 * @return
	 */
	Object get(int i);
	/**
	 * 取得集合大小
	 * @return
	 */
	int size();
}
