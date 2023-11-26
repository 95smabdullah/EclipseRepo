package day6.giftSystem;

public class ShoppingGiftCard extends Gift{

	public ShoppingGiftCard(String brandName) {
		super(brandName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Gift Card: " + BrandName;
	}

}
