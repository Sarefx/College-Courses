
public class SeparateChainingHashTableTester2 {

	public static void main(String[] args) {
		SeparateChainingHashTable2<Student> stu = new SeparateChainingHashTable2<>(0, .5);
		System.out.println("Empty");
		stu.printTable();
		stu.insert(new Student("JET", "CS", 4.0, 123));
		stu.insert(new Student("Bob", "CS", 4.0, 123));
		System.out.println("2 inserted");
		stu.printTable();
		stu.insert(new Student("Ted", "CS", 4.0, 123));
		System.out.println("1 more inserted");
		stu.printTable();
	}

}
