package creation_pattern.factory;

import creation_pattern.factory.impl.Sender;

/**
 * 工厂模式
 * @author smilesnake
 *
 */
public class SendFactory {
	public Sender produceMail() {
		return new MailSender();
	}

	public Sender productSms() {
		return new SmsSender();
	}

	public static void main(String[] args) {
		SendFactory factory = new SendFactory();
		Sender sender = factory.productSms();
		sender.Send();
	}
}
