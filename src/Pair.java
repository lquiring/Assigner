import java.util.ArrayList;
import java.util.List;

public class Pair {
	protected List<String> students;
	
	//constructor
	protected Pair(String student1, String student2) {
		this.setPair(student1, student2);
	}
	
	//getter
	protected List<String> getPair() {
		return this.students;
	}
	
	//get element
	protected String get(int index) {
		return this.students.get(index);
	}
	
	//setter
	protected void setPair(String student1, String student2) {
		List<String> l = new ArrayList<String>();
		l.add(student1);
		l.add(student2);
		this.students = l;
	}
	
	//add to make it a triple
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
