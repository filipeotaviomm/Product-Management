import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ProductController {
  public List<ProductModel> products = new ArrayList<>();

  public String create(ProductModel payload) throws Exception {
    if(payload.getPriceInCents() <= 0) {
      throw new NegativePriceException(
        "The product price must be a positive number."
      );
    }

    products.add(payload);
    return "Product " + payload.getName() + " added.";
    // return String.format("Product %s added.", payload.getName());
  }

  public List<ProductModel> read() {
    return this.products;
  }

  public int retrievePrice(String barCode) throws Exception {

    // usa-se a classe Optional quando a variável tem chance de ser null
    Optional<ProductModel> foundProduct = products.stream()
                .filter(product -> product.getBarCode().equals(barCode))
                .findFirst();

    if (!foundProduct.isPresent()) {
      throw new NotFoundException("Invalid bar code");
    }

    return foundProduct.get().getPriceInCents();

  }
}