package StreamAPI;

public class Phone2 {
	private String name;
	private String company;
	private int price;

	public Phone2(String name, String company, int price) {
		this.name = name;
		this.company = company;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Phone2{" +
				"name='" + name + '\'' +
				", company='" + company + '\'' +
				", price=" + price +
				'}';
	}
}
