package day6.librarySystem;

public class Main {
	public static void main(String[] args) {
		ILibrarySystem ls = new LibrarySystem();
		IBook b1 = new Book(1, "book1", "cat4", "me1", 206 );
		ls.addBook(b1, 14);
		IBook b2 = new Book(2, "book2", "cat2", "me2", 527 );
		ls.addBook(b2, 23);
		IBook b3 = new Book(3, "book3", "cat2", "me2", 734 );
		ls.addBook(b3, 6);
		IBook b4 = new Book(4, "book4", "cat1", "me1", 58 );
		ls.addBook(b4, 29);
		
		System.out.println(ls.calculateTotal());
		System.out.println(ls.categoryTotalPrice().toString());
		for (BooksInfo bi : ls.booksInfo()) {
			System.out.println(bi.toString());
		
		}
		ls.categoryAndAuthorWithCount();
		
	}

}
