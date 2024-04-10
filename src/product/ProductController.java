import java.util.Arraylist;
import java.util.List;

public class ProductController {
  private List<ProductModel> products = new ArrayList<>()

  public String create(ProductModel payload) throw Exception {
    if(payload.getPriceInCents <= 0) {
      throw new NegativePriceException(
        "The product price must be a positive number."
      )
    }

    products.add(payload);
    return "Product " + payload.getName() + " added.";
    // return String.format("Product %s added.", payload.getName());
  }

  public List<ProductModel> read() {
    return this.products;
  }

  public int retrievePrice(String barCode) throw Exception {

    Optional<ProductModel> = products.stream()
                .filter(product -> product.getBarCode().equals(barCode))
                .findFirst();

    if (!foundProduct.isPresent()) {
      throw new NotFoundException("Invalid bar code")
    }

    return foundProduct.get().getPriceInCents();

  }
}