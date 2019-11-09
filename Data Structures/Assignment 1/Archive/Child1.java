
public class Child1 extends MyClass {
	private int anotherValue;
	public Child1(String name, String moreData, int anotherValue) {
		super(name, 0, moreData);
		this.anotherValue = anotherValue;
	}
	public Child1(String name, int value, String moreData) {
		super(name, value, moreData);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Child1 [anotherValue=" + anotherValue + "]";
	}
	public int getAnotherValue() {
		return anotherValue;
	}
	public void setAnotherValue(int anotherValue) {
		this.anotherValue = anotherValue;
	}

}
