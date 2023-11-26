package day6.giftSystem;

import java.util.Queue;

public class Company implements ICompany{
	
	private int LaptopCount;
	private int MobilePhoneCount;
	private int ShoppingGiftCardCount;
	private Queue<Gift> _gifts; 
	
	public Company() {
		LaptopCount = 0;
		MobilePhoneCount = 0;
		ShoppingGiftCardCount = 0;
		
	}
	

	@Override
	public void AddGift(Gift gift) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Gift GiveAway() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int GetLaptopCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int GetMobilePhoneCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int GetShoppingGiftCardCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
