package creation_pattern.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 原型模式
 * <p>
 * 虽然是创建型的模式，但是与工程模式没有关系，从名字即可看出，
 * </p>
 * <p>
 * 该模式的思想就是将一个对象作为原型，对其进行复制、克隆，产生一个和原对象类似的新对象。
 * </p>
 * 
 * @author smilesnake
 *
 */
public class Prototype implements Cloneable, Serializable {

	private String string;

	private SerializableObject obj;

	/**
	 * 浅拷贝
	 */
	public Object clone() throws CloneNotSupportedException {
		Prototype prototype = (Prototype) super.clone();
		return prototype;
	}
	/**
	 * 深拷贝
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public Object deepClone() throws ClassNotFoundException, IOException {
		/* 写入当前对象的二进制流 */
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		
		/* 读出二进制流产生的新对象 */
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public SerializableObject getObj() {
		return obj;
	}

	public void setObj(SerializableObject obj) {
		this.obj = obj;
	}

	class SerializableObject implements Serializable {
		private static final long serialVersionUID = 1L;
	}

}
