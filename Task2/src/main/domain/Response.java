package domain;

public class Response {

	private Item item;
	private int change;

	public Response(Item item, int change) {
		this.item = item;
		this.change = change;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getChange() {
		return change;
	}

	public void setChange(int change) {
		this.change = change;
	}

}
