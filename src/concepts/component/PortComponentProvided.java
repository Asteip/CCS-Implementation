package concepts.component;

public class PortComponentProvided implements InterfaceComponentProvided {
	private String _name;
	private String _msg;
	
	public PortComponentProvided(String name, String msg) {
		_name = name;
		_msg = msg;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getMsg() {
		return _msg;
	}

	public void setMsg(String msg) {
		_msg = msg;
	}

}
