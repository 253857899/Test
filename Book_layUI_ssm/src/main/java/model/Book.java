package model;

public class Book {

	
	private int id;
	private String name;
	private int state;
	private int typeid;
	private String typename;
	
	public static String[] states = {"´ı","Ê£Óà","ÊÛ¿Õ"};
	public String getStatename() {
		return states[state];
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	
	
}
