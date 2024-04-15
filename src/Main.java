public class Main {
    public static void main(String[] args) {

        ProductModel arroz = new ProductModel("Arroz", 50, 5); 
        ProductModel feijao = new ProductModel("Feijão", 80, 8);  
        ProductController controller = new ProductController();

        try {
            controller.create(arroz);
            controller.create(feijao);
            System.out.println(controller.products.get(1).getName());
            System.out.println(controller.read());
            System.out.println(controller.retrievePrice(
                arroz.getBarCode())
            );
        } catch (NegativePriceException error) {
            System.out.println(error.getMessage());
        } catch (NotFoundException error) {
            System.out.println(error.getMessage());
        } catch (Exception error) { 
            System.out.println(error.getMessage());
        }
    }
}

