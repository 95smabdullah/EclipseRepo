package day6.librarySystem;


public class Book implements IBook {
	private int id;
	private String title;
	private String category;
	private String author;
	private int price;
	
	
	
	public Book(int id, String title, String category, String author, int price) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.author = author;
		this.price = price;
	}
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public String getTitle() {
		return title;
	}
	
	@Override
	public String getCategory() {
		return category;
	}
	
	@Override
	public String getAuthor() {
		return author;
	}
	
	@Override
	public int getPrice() {
		return price;
	}
	
	
	
	
}
