package creation_pattern.absFactory.impl;

import creation_pattern.factory.impl.Sender;

public interface Provider {
	public Sender produce();
}
