package utils;

public class Port {
	private String name;
	private Type type;
	private String msg;
	
	public Port(String name, Type type, String msg) {
		this.name = name;
		this.type = type;
		this.msg = msg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		System.out.println("Port " + name + " has recieved the message : " + msg);
		this.msg = msg;
	}
}
