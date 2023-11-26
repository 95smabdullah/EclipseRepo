package day6.giftSystem;

abstract public class Gift implements IGift {
	
	protected String BrandName;
	
	public Gift(String brandName) {
		this.BrandName=brandName;
	}
}
