package behavior_pattern.iterator.impl;

import behavior_pattern.iterator.Collection;
import behavior_pattern.iterator.Iterator;

public class MyCollection implements Collection{
	public String string[];
	
	
	public MyCollection(String[] string) {
		super();
		this.string = string;
	}

	@Override
	public Iterator iterator() {
		return new MyIterator(this);
	}

	@Override
	public Object get(int i) {
		return string[i];
	}

	@Override
	public int size() {
	
		return string.length;
	}

}
