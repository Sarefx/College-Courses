
public class MyClass {
	private String name;
	private int value;
	private String moreData;
	public MyClass(String name, int value, String moreData) {
		super();
		this.name = name;
		this.value = value;
		this.moreData = moreData;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getMoreData() {
		return moreData;
	}
	public void setMoreData(String moreData) {
		this.moreData = moreData;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "MyClass [name=" + name + ", value=" + value + ", moreData=" + moreData + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((moreData == null) ? 0 : moreData.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + value;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyClass other = (MyClass) obj;
		if (moreData == null) {
			if (other.moreData != null)
				return false;
		} else if (!moreData.equals(other.moreData))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value != other.value)
			return false;
		return true;
	}
}
