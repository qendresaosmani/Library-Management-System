import java.util.Scanner;

public class Student {
	private String id;
	private String emriStudentit;
	private Book[] librat;
	private int index = 0;

	public Student(String pid, String pemriStudentit, int nrLibrave) {
		id = pid;
		emriStudentit = pemriStudentit;
		librat = new Book[nrLibrave];
	}
	
	public int getindex(){
		return index;
	}

	public String getEmri(){
		return emriStudentit;
	}
	public void getInformata(){
		System.out.println("The srudent: " + emriStudentit + " with id " + id + " can have " + librat.length + " books");
		for(int i = 0; i < index; i++){
			System.out.println(i + ")" + librat[i].toString());
		}
	}


	public boolean aEPosedonKeteLiber(Book a) {
		for(int i = 0; i < index; i++){
			if(librat[i].equals(a))
				return true;
		}
		return false;
	}

	public void regjistroLibrin(Book a) {
		
		if(a == null){
			System.out.println("The book is not initialized!");
			return;
		}
		
		if(aEPosedonKeteLiber(a)){
			System.out.println("The student possesses this book now!");
			return;
		}
		
		if(index == librat.length){
			System.out.println("There is no place in array!");
			return;
		}
		
		librat[index++] = a;
	}

	
	public Book[] ktheLibrat(){
		return librat;
	}


	public void fshijaStudentitLibrin(int id){
		
		if(index == 0)
			return;
	
		for(int i = 0; i < index; i++){
      			if(i == id) {
				for(int j = i; j < index-1; j++) {
					librat[j] = librat[j + 1];
				}
				
				index--;
				librat[index] = null;
				break;
			}
		}
		
		System.out.println("The remaining books are: \n");
		for(int i = 0; i < index; i++){
			System.out.println(i + ") " + librat[i].toString());
		}
	}

	

	
}