package behavior_pattern.observer.mode2;



public interface Subject {
	/* 登记 */
	public void register(Observer obj);

	/* 注销 */
	public void unregister(Observer obj);

	/* 通知所有的观察者 */
	public void notifyObservers();

	/* 得到更新 */
	public Object getUpdate(Observer obj);

}
