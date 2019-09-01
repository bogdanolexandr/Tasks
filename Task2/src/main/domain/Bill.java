package domain;

public enum Bill {

	ONE(1), FIVE(5), TEN(10), TWENTY(20);

	private int nominal;

	Bill(int nominal) {
		this.nominal = nominal;
	}

	public int nominal() {
		return nominal;
	}

}
