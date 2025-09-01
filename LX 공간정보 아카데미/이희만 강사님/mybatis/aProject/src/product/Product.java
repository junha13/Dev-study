package product;

public class Product {
	
	public String name;
	public int charge;
	
	public static int totalCharge;
	
	public Product(String name, int charge) {
		this.name = name;
		this.charge = charge;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
		
	}

}
