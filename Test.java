import java.util.Scanner;

public class Test {
	
	public static Student regjistroStudent(){

		Scanner input = new Scanner(System.in);

		int nrLbr;
		String emriStudentit;
		String id;

		System.out.println("Enter the Student ID");
		id = input.nextLine();
		System.out.println("Enter the name of the student");
		emriStudentit = input.nextLine();
		System.out.println("Enter the number of books that this student will own");
		nrLbr = input.nextInt();

		Student studenti1 = new Student(id, emriStudentit, nrLbr);
		return studenti1;

	}

	public static Book regjistroLiber(){

		Scanner input = new Scanner(System.in);

		String id;
		String emriLibrit;
		String autori;
		double cmimi;

		System.out.println("Enter your book ID");
		id = input.nextLine();
		System.out.println("Enter the name of the book");
		emriLibrit = input.nextLine();
		System.out.println("Enter the author of the book");
		autori = input.nextLine();
		System.out.println("Enter the price of the book");
		cmimi = input.nextDouble();

		Book libri1 = new Book(id, emriLibrit, autori, cmimi);
		return libri1;

	}
	
	public static void main(String [] args){

		Scanner input = new Scanner(System.in);

		Student[] studentat;
		System.out.println("Enter the number of students");
		int nrStudentave;
		nrStudentave = input.nextInt();
		studentat = new Student[nrStudentave];

		Book[] librat;
		System.out.println("Enter the number of books");
		int nrILibrave;
		nrILibrave = input.nextInt();
		librat = new Book[nrILibrave];

		int currentLibriNr = 0;
		int currentStudentiNr = 0;

		int option = 0;
		do {
			System.out.println("Choose option: \n" +
                            "1) Record student \n" +
                            "2) Register new Liber \n" +
                            "3) View all students \n" +
                            "4) View all books \n" +
                            "5) I donate a student book \n" +
                            "6) Take a student book \n" +
                            "7) View the books that a student has \n" +
                            "8) Delete a student \n" +
                            "9) Delete a book \n" +
                           "10) Stop the program");
			option = input.nextInt();
			
			if(option == 1){
				if(currentStudentiNr < studentat.length){
					studentat[currentStudentiNr] = regjistroStudent();
					currentStudentiNr++;
				}
				else {
					System.out.println("The number of students is filled");
				}
			}
			
			else if(option == 2){
				if(currentLibriNr < librat.length){
					librat[currentLibriNr] = regjistroLiber();
					currentLibriNr++;
				}
				else {
					System.out.println("The number of books is filled");
				}
			}
			
			else if(option == 3){
				for(int i = 0; i < currentStudentiNr; i++){
					studentat[i].getInformata();
				}
			}
			
			else if(option == 4){
				for(int i = 0; i < currentLibriNr; i++){
					System.out.println(librat[i].toString());
				}
			}
			
			else if(option == 5){

				if(currentStudentiNr==0){
					System.out.println("There is no student to donate any book");
					break;
				}

				System.out.println("Enter the serial number of the student you want to give the book\n");
				for(int i = 0; i < currentStudentiNr; i++){
					System.out.println("\t" + i + ") " + studentat[i].getEmri());
				}
				int tempNrserikStudent;
				int tempNrSerikLibri;
				tempNrserikStudent = input.nextInt();
				
				while(tempNrserikStudent >= currentStudentiNr || tempNrserikStudent < 0){
					System.out.println("This serial number does not exist, please enter again");
					tempNrserikStudent = input.nextInt();
				}

				System.out.println("Enter the serial number of the book you want to donate to the student");
				for(int i = 0; i < currentLibriNr; i++){
					System.out.println("\t" + i + ") " + librat[i].getEmri());
				}
				tempNrSerikLibri = input.nextInt();
				
				while(tempNrSerikLibri > nrILibrave || tempNrSerikLibri < 0){
					System.out.println("This serial number does not exist, please enter again");
					tempNrSerikLibri = input.nextInt();
				}
				studentat[tempNrserikStudent].regjistroLibrin(librat[tempNrSerikLibri]);
			}
			
			else if(option == 6){


				if(currentStudentiNr==0){
					System.out.println("There is no student to delete the books");
					break;
				}
				System.out.println("Enter the serial number of the student you want to delete the book");
				int tempNrserikStudent;
				int tempNrSerikLibri;
				tempNrserikStudent = input.nextInt();
				
				while(tempNrserikStudent >= currentStudentiNr || tempNrserikStudent < 0){
					System.out.println("This serial number does not exist, please enter again");
					tempNrserikStudent = input.nextInt();
				}
				System.out.println("Students possess these books: \n");
				Book[] tempLibrat = studentat[tempNrserikStudent].ktheLibrat(); 
				for(int i = 0; i < studentat[tempNrserikStudent].getindex(); i++){
					System.out.println(i + ") " + tempLibrat[i].toString());
				}

				System.out.println("Enter the serial number of the book you want to delete the student");
				tempNrSerikLibri = input.nextInt();
				
				while(tempNrSerikLibri >= studentat[tempNrserikStudent].getindex() || tempNrSerikLibri < 0){
					System.out.println("This book does not exist, please enter the correct serial number");
					tempNrSerikLibri = input.nextInt();
				}
				studentat[tempNrserikStudent].fshijaStudentitLibrin(tempNrSerikLibri);
			}
			
			else if(option == 7){
				if(currentStudentiNr==0){
					System.out.println("There is no student to watch the books");
					break;
				}
				int tempNrserikStudent;
				System.out.println("Enter the serial number of the student");
				tempNrserikStudent = input.nextInt();
			
				while(tempNrserikStudent >= currentStudentiNr || tempNrserikStudent < 0){ 
					System.out.println("This serial number does not exist, please enter again");
					tempNrserikStudent = input.nextInt();
				}
				Book[] tempLibrat = studentat[tempNrserikStudent].ktheLibrat(); 
				for(int i = 0; i <  studentat[tempNrserikStudent].getindex(); i++){
					System.out.println(tempLibrat[i].toString());
				}
			}
			
			else if(option == 8){
				if(currentStudentiNr==0){
					System.out.println("There is no student to delete it");
					break;
				}
				System.out.println("The names of students are: \n");
				for(int i =0 ; i < currentStudentiNr; i++){
					System.out.println(i + ") " + studentat[i].getEmri());
				}
				System.out.println("Enter the serial number of the student you want to delete");
				int tempNrserikStudent;
				tempNrserikStudent = input.nextInt();
				
				while(tempNrserikStudent >= currentStudentiNr || tempNrserikStudent < 0){
					System.out.println("This serial number does not exist, please enter the correct numbere");
					tempNrserikStudent = input.nextInt();
				}
				for(int j = 0; j < currentStudentiNr; j++){
					if(j == tempNrserikStudent){
						for(int i = j; i < currentStudentiNr-1; i++){
							studentat[i] = studentat[i+1];
						}
						currentStudentiNr--;
						studentat[currentStudentiNr] = null;
						break;
					}
				}
			}
			
			else if(option == 9){
				if(currentLibriNr==0){
					System.out.println("There is no book to delete it.");
					break;
				}
				System.out.println("The names of the books are: \n");
				for(int i =0 ; i < currentLibriNr; i++){
					System.out.println(i + ") " + librat[i].toString());
				}
				System.out.println("Enter the serial number of the book you want to delete");
				int tempNrSerikLibri;
				tempNrSerikLibri = input.nextInt();
				
				while(tempNrSerikLibri >= currentLibriNr || tempNrSerikLibri < 0){
					System.out.println("This serial number does not exist, please enter the correct number");
					tempNrSerikLibri = input.nextInt();
				}
				for(int j = 0; j < currentLibriNr; j++){
					if(j == tempNrSerikLibri){
						for(int i = j; i < currentLibriNr-1; i++){
							librat[i] = librat[i+1];
						}
						currentLibriNr--;
						librat[currentLibriNr] = null;
						break;
					}
				}
			}
		}
		while(option != 10);
	}
}