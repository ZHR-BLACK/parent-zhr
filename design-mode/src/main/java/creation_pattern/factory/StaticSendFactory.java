package creation_pattern.factory;

import creation_pattern.factory.impl.Sender;

/**
 * 静态工厂
 * @author smilesnake
 *
 */
public class StaticSendFactory {
	public static Sender produceMail() {
		return new MailSender();
	}

	public static Sender productSms() {
		return new SmsSender();
	}

	public static void main(String[] args) {
		StaticSendFactory.productSms().Send();
	}
}
