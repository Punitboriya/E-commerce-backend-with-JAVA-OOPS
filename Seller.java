import java.util.ArrayList;

public class Seller extends User{
	private ArrayList<Product> productsListed;
	
	@Override
	public Boolean verifyUser() {
		return true;
	}
	public ArrayList<Product> getProductsListed() {
		return productsListed;
	}
	public void setProductsListed(ArrayList<Product> productsListed) {
		this.productsListed = productsListed;
	}

}
