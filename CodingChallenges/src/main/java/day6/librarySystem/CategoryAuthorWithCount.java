package day6.librarySystem;

public class CategoryAuthorWithCount {
    private String category;
    private String author;
    private int count;

    public CategoryAuthorWithCount(String category, String author, int count) {
        this.category = category;
        this.author = author;
        this.count = count;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    public int getCount() {
        return count;
    }
    @Override
    public String toString(){
		return "cat: "+ category +" author "+ author +" quantity "+ count;
    	
    }
}
