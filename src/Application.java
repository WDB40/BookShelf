import java.util.List;
import java.util.Scanner;

import controller.AuthorHelper;
import controller.BookShelf;
import controller.GenreHelper;
import model.Author;
import model.Book;
import model.Genre;

public class Application {
	
	static Scanner in = new Scanner(System.in);
	static BookShelf bookShelf = new BookShelf();
	static AuthorHelper authorHelper = new AuthorHelper();
	static GenreHelper genreHelper = new GenreHelper();
	
	public static void main(String[] args) {
		runMenu();
	}
	
	public static void runMenu() {
		boolean stillBrowsing = true;
		
		System.out.println("---- Welcome to the Kanawha County Library ----");
		
		while(stillBrowsing) {
			
			System.out.println("** Select an Option:");
			System.out.println("** 1 -- Return a book.");
			System.out.println("** 2 -- Correct book information.");
			System.out.println("** 3 -- Checkout a book.");
			System.out.println("** 4 -- View all available books.");
			System.out.println("** 5 -- Leave the library.");
			
			System.out.println("** Your selection? ");
			int selection = in.nextInt();
			in.nextLine();
			
			if(selection == 1) {
				returnBook();
			} else if(selection == 2){
				correctBookInformation();
			} else if(selection == 3) {
				checkoutBook();
			} else if(selection == 4) {
				viewAllBooks();
			} else if(selection == 5) {
				bookShelf.cleanUp();
				System.out.println("** Come again!");
				stillBrowsing = false;
			} else {
				System.out.println("** Hey now, that's not valid.");
				System.out.println("** Let's try this again...");
			}
		}
	}
	
	private static void returnBook() {
		System.out.println("Enter the title: ");
		String title = in.nextLine();
		
		System.out.println("Enter the author's first name: ");
		String authorFirstName = in.nextLine();
		
		System.out.println("Enter the author's last name: ");
		String authorLastName = in.nextLine();
		
		System.out.println("Enter the genre: ");
		String genreName = in.nextLine();
		
		Author author = new Author(authorFirstName, authorLastName);
		Genre genre = new Genre(genreName);
				
		Book returnedBook = new Book(title, author, genre);
		bookShelf.addBook(returnedBook);
	}
	
	private static void correctBookInformation() {
		
		System.out.println("How would you like to search?");
		System.out.println("1: By title.");
		System.out.println("2: By author.");
		System.out.println("3. By genre.");
		
		int searchSelection = in.nextInt();
		in.nextLine();
		
		List<Book> foundBooks;
		
		if(searchSelection == 1) {
			System.out.println("Enter the title of the book: ");
			String title = in.nextLine();
			
			foundBooks = bookShelf.searchForBookByTitle(title);
			
		} else if(searchSelection == 2) {
			System.out.println("Enter the author's first name: ");
			String authorFirstName = in.nextLine();
			
			System.out.println("Enter the author's last name: ");
			String authorLastName = in.nextLine();
			
			Author author = new Author(authorFirstName, authorLastName);
			
			foundBooks = bookShelf.searchForBookByAuthor(author);
			
		} else {
			System.out.println("Enter the genre: ");
			String genreName = in.nextLine();
			
			Genre genre = new Genre(genreName);
			
			foundBooks = bookShelf.searchForBookByGenre(genre);
			
		}
		
		if(!foundBooks.isEmpty()) {
			System.out.println("Here's what we found:");
			
			for(Book book : foundBooks) {
				System.out.println(book.getId() + ": " + book);
			}
			
			System.out.println("Which book needs corrected? Enter the ID: ");
			int id = in.nextInt();
			
			Book book = bookShelf.searchForBookById(id);
			
			System.out.println("Alrighty, I've got " + book);
			System.out.println("1: Title.");
			System.out.println("2: Author.");
			System.out.println("3: Genre.");
			
			System.out.println("Which do you want to correct?");
			int correction = in.nextInt();
			in.nextLine();
			
			if(correction == 1) {
				System.out.println("Enter the new title: ");
				String title = in.nextLine();
				
				book.setTitle(title);
				
			} else if(correction == 2) {
				System.out.println("Enter the new first name for the author: ");
				String authorFirstName = in.nextLine();
				
				System.out.println("Enter the new first name for the author: ");
				String authorLastName = in.nextLine();
				
				Author author = new Author(authorFirstName, authorLastName);
				
				book.setAuthor(author);
				
			} else if(correction == 3) {
				System.out.println("Enter the new genre: ");
				String genreName = in.nextLine();
				
				Genre genre = new Genre(genreName);
				
				book.setGenre(genre);
			}
			
			bookShelf.updateBook(book);
			
		} else {
			System.out.println("Sorry, no books like that were found.");
		}
	}
	
	private static void checkoutBook() {
		System.out.println("Enter the title: ");
		String title = in.nextLine();
		
		System.out.println("Enter the author's first name: ");
		String authorFirstName = in.nextLine();
		
		System.out.println("Enter the author's last name: ");
		String authorLastName = in.nextLine();
		
		System.out.println("Enter the genre: ");
		String genreName = in.nextLine();
		
		Author author = new Author(authorFirstName, authorLastName);
		Genre genre = new Genre(genreName);
		
		Book book = new Book(title, author, genre);
		
		bookShelf.removeBook(book);
	}
	
	private static void viewAllBooks() {
		List<Book> allBooks = bookShelf.showAllBooks();
		
		for(Book book : allBooks) {
			System.out.println(book);
		}
	}

}
