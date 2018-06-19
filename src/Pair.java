import java.util.ArrayList;
import java.util.List;

public class Pair {
	protected List<String> students;
	
	protected List<String> getPair() {
		return this.students;
	}
	
	protected String get(int index) {
		return this.students.get(index);
	}
	
	protected void setPair(String student1, String student2) {
		List<String> l = new ArrayList<String>();
		l.add(student1);
		l.add(student2);
		this.students = l;
	}
	
	protected void add(String student) {
		this.students.add(student);
	}
	
	protected boolean isEmpty() {
		if(this.students.size() == 0) {
			return true;
		}
		return false;
	}
	
	protected int size() {
		return this.students.size();
	}
}
