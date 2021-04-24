public abstract class Class {

	private char id;
	private String name;
	private double priceModifier;
	private int maxCapacity;

	public Class(){};

	public char getId() {
		return id;
	}

	public void setId(char id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPriceModifier() {
		return priceModifier;
	}

	public void setPriceModifier(double priceModifier) {
		this.priceModifier = priceModifier;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}


}


