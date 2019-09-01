package domain;

public enum Item {

	HEADSET("Bluetooth-headset", 65), SPEAKER("Portable-speaker", 35), DVD("6-DVDs", 45);

	private String title;
	private int price;

	Item(String title, int price) {
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}

}
