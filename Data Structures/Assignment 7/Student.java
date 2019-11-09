
public class Student {
	private String name;
	private String major;
	private double gpa;
	private int creditHours;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Student other = (Student) obj;
		/*
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		*/
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public Student(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", major=" + major + ", gpa=" + gpa + ", creditHours=" + creditHours + "]";
	}
	public Student(String name, String major, double gpa, int creditHours) {
		super();
		this.name = name;
		this.major = major;
		this.gpa = gpa;
		this.creditHours = creditHours;
	}
}
