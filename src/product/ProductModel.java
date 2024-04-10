import java.util.UUID;

public class ProductModel {
  private String barCode;
  private String name;
  private int priceInCents;
  private int stock;

  ProductModel(String name, int priceInCents, int stock) {
    this.barCode = UUID.randomUUID().toString();
    this.name = name;
    this.priceInCents = priceInCents;
    this.stock = stock;
  }

  public String getBarCode() {
    return this.barCode;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String newName) {
    this.name = newName;
  }

  public int getPriceInCents() {
    return this.priceInCents;
  }

  public void setPriceInCents(int newPrice) {
    this.priceInCents = newPrice;
  }

  public int getStock() {
    return this.stock;
  }

  public void setStock(int newStock) {
    this.stock = newStock;
  }
}