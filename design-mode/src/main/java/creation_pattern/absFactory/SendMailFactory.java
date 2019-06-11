package creation_pattern.absFactory;

import creation_pattern.absFactory.impl.Provider;
import creation_pattern.factory.MailSender;
import creation_pattern.factory.impl.Sender;

public class SendMailFactory implements Provider{
	@Override
	public Sender produce() {
		return new MailSender();
	}
}