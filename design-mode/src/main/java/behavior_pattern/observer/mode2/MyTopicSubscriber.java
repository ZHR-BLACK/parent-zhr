package behavior_pattern.observer.mode2;

import behavior_pattern.observer.mode2.impl.MyTopic;

/**
 * 我的主题用户
 * @author smilesnake
 *
 */
public class MyTopicSubscriber implements Observer {

	private String name;
	private Subject topic;

	public MyTopicSubscriber(String nm) {
		this.name = nm;
	}

	@Override
	public void update() {
		String msg = (String) topic.getUpdate(this);
		if (msg == null) {
			System.out.println(name + ":: 没有新的消息");
		} else
			System.out.println(name + ":: 消费信息::" + msg);
	}

	@Override
	public void setSubject(Subject sub) {
		this.topic = sub;
	}

	public static void main(String[] args) {
		//创建主题
		MyTopic topic = new MyTopic();

		//创建观察者
		Observer obj1 = new MyTopicSubscriber("Obj1");
		Observer obj2 = new MyTopicSubscriber("Obj2");
		Observer obj3 = new MyTopicSubscriber("Obj3");

		// 登记观察者到主题
		topic.register(obj1);
		topic.register(obj2);
		topic.register(obj3);

		// 附加话题到主题
		obj1.setSubject(topic);
		obj2.setSubject(topic);
		obj3.setSubject(topic);

		// 检查是否有任何更新
		obj1.update();

		// 现在发送消息到主题
		topic.postMessage("New Message");
	}

}
