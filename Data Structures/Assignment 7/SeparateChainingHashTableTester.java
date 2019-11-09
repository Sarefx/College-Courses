
public class SeparateChainingHashTableTester {

	public static void main(String[] args) {
		//String name, String major, double gpa, int creditHours
		Student s1 = new Student("JET", "CS", 4.0, 123);
		Student s2 = new Student("Billy", "CS", 4.0, 123);
		Student s3 = new Student("Bob", "CS", 4.0, 123);
		Student s4 = new Student("Ted", "CS", 4.0, 123);
		Student s5 = new Student("Ned", "CS", 4.0, 123);
		//System.out.println("JET".hashCode());
		SeparateChainingHashTable<Student> stu = new SeparateChainingHashTable<>();
		stu.insert(s1);
		stu.insert(s2);
		stu.insert(s3);
		stu.insert(s4);
		stu.insert(s5);
		stu.printTable();
		System.out.println("DELETE");
		stu.delete(new Student("JET"));
		stu.printTable();
		System.out.println(stu.search(new Student("Ned")));

	}

}
