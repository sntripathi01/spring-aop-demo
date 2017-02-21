package spring.aop.demo.model;

public class AddCustomerRequest {

	
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "AddCustomerRequest [ name=" + name + "]";
	}
}
