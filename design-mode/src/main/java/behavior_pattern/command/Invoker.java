package behavior_pattern.command;

/**
 * 命令模式--命令模式的目的就是达到命令的发出者和执行者之间解耦，实现请求和执行分开
 * 
 * 调用者
 * @author smilesnake
 *
 */
public class Invoker {
	private Command command;

	public Invoker(Command command) {
		super();
		this.command = command;
	}
	
	public void action(){
		command.exe();
	}



	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		Command cmd = new MyCommand(receiver);
		Invoker invoker = new Invoker(cmd);
		invoker.action();
	}
}
