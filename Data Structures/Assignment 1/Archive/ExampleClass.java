
public class ExampleClass {

	public static void main(String[] args) {
		GenericClass<Integer> gInt = new GenericClass<>(5);
		System.out.println(gInt);
		GenericClass<String> gStr = new GenericClass<>("JET");
		System.out.println(gStr);
		MyClass mc = new Child1("JET", "CS", 5);
		String[] a = new String[]{"JET", "a", "c"};
		Integer[] b = new Integer[]{1,5,8,0};
		System.out.println(contains(a, "c"));
		System.out.println(contains(a, "b"));
		System.out.println(contains(b, 1));
		System.out.println(contains(b, 10));
	}

	public static <genericType> boolean contains(genericType[] arr, genericType x)
	{
		for(genericType t : arr)
		{
			if(t.equals(x))
				return true;
		}
		return false;
	}

}
