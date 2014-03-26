package dom.entity;

import com.namoo.ns1.common.Identifiable;

public class IdValue implements Identifiable{

	private static final long serialVersionUID = -3451103639698915547L;
	
	private String name;
	private int value;
	
	public IdValue(String name) {
		// 
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public String getOId() {
		// 
		return name;
	}
	public void increase() {
		// 
		value++;
	}
	
	
}
