package creation_pattern.factory;

import creation_pattern.factory.impl.Sender;

public class MailSender implements Sender {

	@Override
	public void Send() {
		System.out.println("发送邮件!!!");
	}

}
