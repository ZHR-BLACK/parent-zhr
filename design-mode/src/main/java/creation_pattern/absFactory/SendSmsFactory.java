package creation_pattern.absFactory;

import creation_pattern.absFactory.impl.Provider;
import creation_pattern.factory.SmsSender;
import creation_pattern.factory.impl.Sender;

public class SendSmsFactory implements Provider {

	@Override
	public Sender produce() {
		return new SmsSender();
	}
	
}
