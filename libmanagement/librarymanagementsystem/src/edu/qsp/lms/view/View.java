package edu.qsp.lms.view;

import java.util.Scanner;

import edu.qsp.lms.controller.LibraryController;
import edu.qsp.lms.model.Book;
import edu.qsp.lms.model.Library;

public class View {
	static Scanner myInput = new Scanner(System.in);
	static LibraryController controller = new LibraryController();
	static Library library = new Library();

	static {
		System.out.println("-----WELCOME TO LIBRARY MANAGEMENT SYSTEM----");
		//
		System.out.println("Enter name of the library: ");
		String libraryName = myInput.nextLine();
				
		library.setLibraryName(libraryName);
		System.out.println("Enter address of the library: ");
		String libraryAddress = myInput.nextLine();
		library.setLibraryAddress(libraryAddress);
		System.out.println("Enter pincode:");
		int libraryPincode = myInput.nextInt();
		myInput.nextLine();
		library.setLibraryPincode(libraryPincode);

	}

	public static void main(String[] args) {
		do {
			System.out.println("Select operation to perform:");
			System.out.println(
					"1.Add book\n2.Remove book \n3.Update Book \n4.Get book by book name \n5.Get all book \n0.Exit");
			System.out.println("Enter digit respective to desired option: ");
			int userChoice = myInput.nextInt();
			myInput.nextLine();
			switch (userChoice) {
			case 0:
				myInput.close();
				System.out.println("-----Exited-----");
				System.exit(0);
				break;

			case 1:
				Book book1 = new Book();
				//
				System.out.println("Enter book name: ");
				book1.setBookName(myInput.nextLine());
				System.out.println("Enter author name: ");
				book1.setBookAuthor(myInput.nextLine());
				System.out.println("Enter price of the book :");
				book1.setPrice(myInput.nextDouble());
				System.out.println("Enter publication: ");
				myInput.nextLine();
				book1.setPublication(myInput.nextLine());
				//
				controller.addBook(book1);
				break;
			case 2:
				System.out.println("Enter the name of the book to be removed: ");
				String booktobeRemoved = myInput.nextLine();
				boolean verify = controller.removeBookByBookName(booktobeRemoved);
				if (verify) {
					System.out.println("Book is removed from the library");
				} else {
					System.out.println("Book does not exist");
				}
				break;
			case 3:
				Book book3 = new Book();
				System.out.println("Enter book to update");
				String booktobeUpdate = myInput.nextLine();
				book3.setBookName(booktobeUpdate);
				System.out.println("Enter price to update : ");
				double newPrice = myInput.nextDouble();
				book3.setPrice(newPrice);

				boolean verifyUpdate = controller.updateBookPriceByBookName(book3);
				if (verifyUpdate) {
					System.out.println("Book price is updated.");
				} else {
					System.out.println("Mentioned book does not exist in library.");
				}
				break;
			case 4:
				System.out.println("Enter name of the book: ");
                String booktoGet =myInput.nextLine();
                //
                Book book4=controller.searchBook(booktoGet);
                if (book4!=null) {
					System.out.println(book4);
				} else {
                    System.out.println("Book not found.");
				}
				break;
			case 5:
                  System.out.println(controller.getAllBooks());
				break;

			default:
				System.out.println("------INVALID SELECTION-----");
				break;
			}

		} while (true);
	}
}
