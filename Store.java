//In this project I used Arraylist for variable size of array/(Dynamic)
import java.util.ArrayList;
import java.util.Scanner;

/* Ask which type of user are you? Customer, Seller, Administrator
 * User- Customer, Seller, Administrator
 * Customer- View products, View cart, Contact Us.
 * View products- Add the product to the cart, View cart- Checkout.
 * Seller- View your products, Add a product, Contact Us
 * View your products- delete this product. Add a product- Submit details of the product.
 * Administrator-......
 * Product
 * Category
 * Cart
 * Order  */
public class Store {
	public static void main(String[] args) {
		System.out.println(" *** Welcome to the E-commerce store *** ");
		System.out.println("Which user are you? 1. Customer 2. Seller 3. Admin");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		String typeOfUser;
		if (choice == 1) {
			typeOfUser = "Customer";
			Customer current = new Customer();
			System.out.println("What is your CustomerId?");
			sc.nextLine();
			current.setUserId(sc.nextLine());
			System.out.println("What is your Password?");
			current.setPassword(sc.nextLine());
			if (current.verifyUser() == true) {
				System.out.println("User verified!");
				while (true) {
					System.out.println("Do you want to- 1. View products 2. View Cart 3. Contact Us 4. Exit");
					choice = sc.nextInt();
					if (choice == 1) {
						Catalogue catalogue = new Catalogue();
						ArrayList<Product> allProducts = catalogue.getListofAllProducts();
						for (int i = 0; i < allProducts.size(); i++) {
							System.out.println(allProducts.get(i).getProductId() + " "
									+ allProducts.get(i).getProductName() + " " + allProducts.get(i).getCost());
						}
						System.out.println("Do you want to add any product to the cart? Y/N");
						sc.nextLine();
						String addToCart = sc.nextLine();
						if (addToCart.equals("Y")) {
							System.out.println("Input the product id of the product which you want to add to cart.");
							String productId = sc.nextLine();
							ArrayList<Product> cartProducts = new ArrayList<Product>();
							for (int i = 0; i < allProducts.size(); i++) {
								if (allProducts.get(i).getProductId().equals(productId))
									cartProducts.add(allProducts.get(i));
							}

							Cart cart = new Cart();
							cart.setCartId("1");
							cart.setListOfProducts(cartProducts);
							current.setCart(cart);
							System.out.println("The product is successfully added to the cart");
						}
					} else if (choice == 2) {
						ArrayList<Product> cartProducts = current.getCart().getListOfProducts();
						System.out.println(current.getCart().getCartId());
						for (int i = 0; i < cartProducts.size(); i++) {
							System.out.println(cartProducts.get(i).getProductId() + " "
									+ cartProducts.get(i).getProductName() + " " + cartProducts.get(i).getCost());
						}
						System.out.println("Do you want to checkout? Y/N");
						sc.nextLine();
						String checkout = sc.nextLine();
						if (checkout.equals("Y"))
							if (current.getCart().checkOut())
								// Create an order object and assign this user to the order with an order id
								System.out.println("Your order is placed successfully");

					} else if (choice == 3) {
						System.out.println("To contact us, please email on store@ecommerce.com");
					} else if (choice == 4) {
						break;
					} else
						System.out.println("Invalid choice, please try again.");

				}
			}
		} else if (choice == 2) {
			typeOfUser = "Seller";
			Catalogue catalogue = new Catalogue();
			Customer current = new Customer();
			System.out.println("What is your Seller Id?");
			sc.nextLine();
			current.setUserId(sc.nextLine());
			System.out.println("What is your Password?");
			current.setPassword(sc.nextLine());
			if (current.verifyUser() == true) {
				System.out.println("User verified!");
				while (true) {
					System.out.println("Do you want to- 1. View Your products 2. Contact Us 3. Exit");
					choice = sc.nextInt();
					if (choice == 1) {

						ArrayList<Product> allProducts = catalogue.getSellerProducts();
						for (int i = 0; i < allProducts.size(); i++) {
							System.out.println(allProducts.get(i).getProductId() + " "
									+ allProducts.get(i).getProductName() + " " + allProducts.get(i).getCost());
						}

						System.out.println("Do you want to- 1. Add products 2. Remove products 3. Exit");
						sc.nextLine();
						choice = sc.nextInt();
						if (choice == 1) {
							catalogue.addProduct(addProduct(catalogue, sc));
						} else if (choice == 2) {
							removeProduct(allProducts, sc, catalogue);
						} else if (choice == 3) {
							
						}
					} else if (choice == 2) {
						System.out.println("To contact us, please email on store@ecommerce.com");
					} else if (choice == 3) {
						break;
					}
					else
						System.out.println("Invalid choice, please try again.");
				}
			}
		} else if (choice == 3) {
			typeOfUser = "Admin";
		Catalogue catalogue = new Catalogue();
		Customer current = new Customer();
		System.out.println("What is your Admin ID?");
		sc.nextLine();
		current.setUserId(sc.nextLine());
		System.out.println("What is your Password?");
		current.setPassword(sc.nextLine());
		if (current.verifyUser() == true) {
			System.out.println("User verified!");
			while (true) {
				System.out.println("Do you want to- 1. View products 2. Contact Us 3. Exit ");
				choice = sc.nextInt();
				if (choice == 1) {
					ArrayList<Product> allProducts = catalogue.getListofAllProducts();
					for (int i = 0; i < allProducts.size(); i++) {
						System.out.println(allProducts.get(i).getProductId() + " " + allProducts.get(i).getProductName()
								+ " " + allProducts.get(i).getCost());
					}
					System.out.println("Do you want to- 1. Add products 2. Remove products 3. Exit");
					sc.nextLine();
					choice = sc.nextInt();
					if (choice == 1) {
						catalogue.addProduct(addProduct(catalogue, sc));
					} else if (choice == 2) {
						removeProduct(allProducts, sc, catalogue);
					} else if (choice == 3) {
						
					}
				}  else if (choice == 2) {
					System.out.println("To contact us, please email on store@ecommerce.com");
				} else if (choice == 3) {
					break;
				} else
					System.out.println("Invalid choice, please try again.");
			}
		   }
		} else
			System.out.println("Invalid input. Try again");
	}

	private static Product addProduct(Catalogue catalogue, Scanner sc) {
		System.out.println("Select Category:");
		ArrayList<Category> allCategory = catalogue.getProductsCategory();
		ArrayList<Product> allProduct = catalogue.getListofAllProducts();
		for (int i = 0; i < allCategory.size(); i++) {
			System.out.println((i + 1) + " " + allCategory.get(i).getCategoryName());
		}
		sc.nextLine();
		int categoryId = Integer.parseInt(sc.nextLine());
		System.out.println("Input the product name of the product");
		String productName = sc.nextLine();
		System.out.println("Input the product price of the product");
		String productPrice = sc.nextLine();
		Product product = new Product();
		product.setProductId("" + (allProduct.size() + 1));
		product.setProductName(productName);
		product.setCost(productPrice);
		product.setCategory(allCategory.get(categoryId - 1));
		return product;
	}

	private static void removeProduct(ArrayList<Product> allProducts, Scanner sc, Catalogue catalogue) {
		for (int i = 0; i < allProducts.size(); i++) {
			System.out.println(allProducts.get(i).getProductId() + " " + allProducts.get(i).getProductName() + " "
					+ allProducts.get(i).getCost());
		}
		System.out.println("Enter product id");
		sc.nextLine();
		String productId = sc.nextLine();
		for (int i = 0; i < allProducts.size(); i++) {
			if (allProducts.get(i).getProductId().equals(productId))
				catalogue.removeProduct(allProducts.get(i));
		}
	}
}