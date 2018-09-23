package hotel.credit;

public class CreditAuthorizer implements ICreditAuthorizer {
	
	private static CreditAuthorizer self;
	
	public static synchronized CreditAuthorizer getInstance() {
		if (self == null) {
			self = new CreditAuthorizer();
		}
		return self;
		
	}


	@Override
	public boolean authorize(ICreditCard card, double amount) {
		int cardNumLength = String.valueOf(card.getNumber()).length();
		if (cardNumLength.getNumber() <= 5) {
			return true;
		}
		return false;
	}

}
