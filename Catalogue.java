import java.util.ArrayList;

public class Catalogue {
	private ArrayList<Product> listofAllProducts = new ArrayList<Product>();
	private ArrayList<Category> listofAllCategory = new ArrayList<Category>();
	private ArrayList<Product> listofSellerProducts = new ArrayList<Product>();

	public ArrayList<Product> getListofAllProducts() {
		if(listofAllProducts.size() > 0) {
			return listofAllProducts;
		}
		Category c1 = new Category();
		c1.setCategoryName("Footware");
		listofAllCategory.add(c1);
		Category c2 = new Category();
		c2.setCategoryName("CellPhone");
		listofAllCategory.add(c2);
		Category c3 = new Category();
		c3.setCategoryName("Sports & fitness");
		listofAllCategory.add(c3);

		Product product1 = new Product();
		product1.setProductId("1");
		product1.setProductName("Sport Shoes");
		product1.setCost("1000");
		product1.setCategory(listofAllCategory.get(0));
		Product product2 = new Product();
		product2.setProductId("2");
		product2.setProductName("Sandal");
		product2.setCost("850");
		product2.setCategory(listofAllCategory.get(0));

		Product product3 = new Product();
		product3.setProductId("3");
		product3.setProductName("One + 7T");
		product3.setCost("35000");
		product3.setCategory(listofAllCategory.get(1));
		Product product4 = new Product();
		product4.setProductId("4");
		product4.setProductName("iPhon 14");
		product4.setCost("95000");
		product4.setCategory(listofAllCategory.get(1));

		Product product5 = new Product();
		product5.setProductId("5");
		product5.setProductName("Badminton Reckets");
		product5.setCost("1500");
		product5.setCategory(listofAllCategory.get(2));
		Product product6 = new Product();
		product6.setProductId("6");
		product6.setProductName("Treadmil");
		product6.setCost("15000");
		product6.setCategory(listofAllCategory.get(2));
	
		listofAllProducts.add(product1);
		listofAllProducts.add(product2);
		listofAllProducts.add(product3);
		listofAllProducts.add(product4);
		listofAllProducts.add(product5);
		listofAllProducts.add(product6);
		listofSellerProducts.add(product1);
		listofSellerProducts.add(product4);
		return listofAllProducts;
	}

	public ArrayList<Product> getSellerProducts() {
		if(listofSellerProducts.size() == 0){
			getListofAllProducts();
		}
		return listofSellerProducts;

	}
	
	public ArrayList<Category> getProductsCategory() {
		if(listofAllCategory.size() == 0){
			getListofAllProducts();
		}
		return listofAllCategory;

	}
	
	public void addProduct(Product product) {
		listofAllProducts.add(product);
		listofSellerProducts.add(product);
	}
	
	public void removeProduct(Product product) {
		listofAllProducts.remove(product);
		listofSellerProducts.remove(product);
	}

	public void setListofAllProducts(ArrayList<Product> listofAllProducts) {
		this.listofAllProducts = listofAllProducts;
	}
}
