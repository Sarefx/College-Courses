
public class GenericClass<E> {
	private E data;

	public GenericClass(E data) {
		super();
		this.data = data;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "GenericClass [data=" + data + "]";
	}

}
