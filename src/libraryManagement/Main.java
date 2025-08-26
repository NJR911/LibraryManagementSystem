package libraryManagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // DBSetup.createDBAndTable();

    	Scanner scanner = new Scanner(System.in);
    	
    	while (true) {
    		System.out.println("\nWelcome to the Library!");
    		System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Show book by id");
            System.out.println("4. Update book");
            System.out.println("5. Delete book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            
            int num = scanner.nextInt();
            scanner.nextLine();
            
            switch(num) {
		    	case 1:
		    		//Title validation
		    		String title = "";
		    		while(true) {	
			    		System.out.print("Enter the book title: ");
			    		title = scanner.nextLine();		  
			    		
			    		if(title.isBlank())	{
			    			System.out.println("Not valid X");
			    		} else {
			    			break;
			    		}
		    		}
		    		
		    		//Author validation
		    		String author = "";
		    		while (true) {
		    			System.out.print("Enter the author: ");
		    			author = scanner.nextLine();
		    			
		    			if(author.isBlank() || !author.matches("[a-zA-Z\\s]+")) {
		    				System.out.println("Not valid X");
			    		} else {
			    			break;
			    		}
		    		}
		    		
		    		// Year validation
		    		int year = 0;
		    		while (true) {
		    		    System.out.print("Enter the year: ");
		    		    if (scanner.hasNextInt()) {
		    		        year = scanner.nextInt();
		    		        scanner.nextLine();
		    		        break;
		    		    } else {
		    		    	System.out.println("Not valid X");
		    		        scanner.nextLine();
		    		    }
		    		}
		    		
		    		Book newBook = new Book(title, author, year);
		    		BookCRUD.addBook(newBook);
		    		
		        	break;
		    	case 2:
		    		BookCRUD.readBooks();
		    		break;
		    	
		    	case 3:
		    	    System.out.print("Enter book ID to view: ");
		    	    int idToRead = scanner.nextInt();
		    	    scanner.nextLine();
		    	    BookCRUD.readBookById(idToRead);
		    	    break;

		    	case 4:
		    	    System.out.print("Enter book ID to update: ");
		    	    int updateId = scanner.nextInt();
		    	    scanner.nextLine();

		    	    System.out.print("Enter new title: ");
		    	    String newTitle = scanner.nextLine();

		    	    System.out.print("Enter new author: ");
		    	    String newAuthor = scanner.nextLine();

		    	    System.out.print("Enter new year: ");
		    	    int newYear = scanner.nextInt();
		    	    scanner.nextLine();

		    	    BookCRUD.updateBook(updateId, newTitle, newAuthor, newYear);
		    	    break;

		    	case 5:
		    	    System.out.print("Enter book ID to delete: ");
		    	    int deleteId = scanner.nextInt();
		    	    scanner.nextLine();
		    	    BookCRUD.deleteBook(deleteId);
		    	    break;

		    	    
		    	case 6:
	                System.out.println("Goodbye!");
	                return;
	                
		    	default:
	                System.out.println("Invalid option, try again.");
            }
    
    	}


    }
}
