package day6.giftSystem;

public interface ICompany {
	
	void AddGift(Gift gift);
	Gift GiveAway();
	int GetLaptopCount();
	int GetMobilePhoneCount();
	int GetShoppingGiftCardCount();

}
