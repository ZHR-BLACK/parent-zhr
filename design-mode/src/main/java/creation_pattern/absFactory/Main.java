package creation_pattern.absFactory;

import creation_pattern.absFactory.impl.Provider;
import creation_pattern.factory.impl.Sender;

public class Main {
	public static void main(String[] args) {
		Provider provider = new SendMailFactory();
		Sender sender = provider.produce();
		sender.Send();
	}
}
