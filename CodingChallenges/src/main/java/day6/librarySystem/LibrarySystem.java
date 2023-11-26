package day6.librarySystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LibrarySystem implements ILibrarySystem {
	
	private Map<IBook,Integer> _books = new HashMap<IBook, Integer>();

	@Override
	public void addBook(IBook book, int quantity) {
		
		_books.put(book, _books.getOrDefault(book, 0)+quantity);
		
	}

	@Override
	public void removeBook(IBook book, int quantity) {
		// TODO Auto-generated method stub
		int qty = _books.get(book);
		if (qty<=quantity){
			_books.remove(book);
		}else {
			qty=quantity-qty;
			_books.put(book, qty);
		}
	}

	@Override
	public int calculateTotal() {
		// TODO Auto-generated method stub
		AtomicInteger total = new AtomicInteger(0);
		_books.forEach((k,v)->{
			 total.addAndGet(v*k.getPrice());
		});
		return total.get();
	}
//	@Override
//	public int calculateTotal() {
//		// TODO Auto-generated method stub
//		int total = 0;
//		for(Map.Entry<IBook, Integer> entry : _books.entrySet()) {
//			total+=entry.getKey().getPrice()*entry.getValue();
//		}
//		return total;
//		
//	}
	

	@Override
	public Map<String, Integer> categoryTotalPrice() {
		// TODO Auto-generated method stub
		Map<String, Integer> catgryPrice = new HashMap<String, Integer>();
		_books.forEach((k,v)->{
			catgryPrice.put(k.getCategory(), catgryPrice.getOrDefault(k.getCategory(), 0)+k.getPrice()*v);
			System.out.println(catgryPrice.toString());
			
		});
		
		return catgryPrice;
	}

	@Override
	public List<BooksInfo> booksInfo() {
		// TODO Auto-generated method stub
		List<BooksInfo> result = new ArrayList<BooksInfo>(); 
		_books.forEach((k,v)->{
			result.add(new BooksInfo(k.getTitle(), v, k.getPrice()));
			
		});
		result.sort(Comparator.comparing(BooksInfo::getTitle).thenComparing(BooksInfo::getQuantity));
		return result;
	}

	@Override
	public List<CategoryAuthorWithCount> categoryAndAuthorWithCount() {
		// TODO Auto-generated method stub
		List<CategoryAuthorWithCount> result = new ArrayList<CategoryAuthorWithCount>();
		Map<String,Map<String,Integer>> catAuthorCountMap = new HashMap<String, Map<String,Integer>>();
		_books.forEach((k,v)->{
			catAuthorCountMap.putIfAbsent(k.getCategory(), new HashMap<String, Integer>());
			catAuthorCountMap.get(k.getCategory()).put(k.getAuthor(), catAuthorCountMap.get(k.getCategory()).getOrDefault(k.getAuthor(), 0)+v);
			
		});
		
		catAuthorCountMap.forEach((k,v)->{
			String cat = k;
			List<String> authors = new ArrayList<>(v.keySet());
			for(String author : authors) {
				result.add(new CategoryAuthorWithCount(cat, author, v.get(author)));
			}
		});
		
		for(CategoryAuthorWithCount ob: result) {
			System.out.println(ob.toString());
		}
//		catAuthorCountMap.forEach((k,v)->{
//			System.out.println(k);
//			System.out.println(v.toString());
//		});
		return null;
	}
}
