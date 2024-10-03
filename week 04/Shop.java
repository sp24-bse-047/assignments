import java.util.Scanner;


public class Shop {
    private String shopName;
    private String shopAddress;
    Product products[]=new Product[100];
    private static int counter=0;
    public Shop(String name,String address){
        this.shopAddress=address;
        this.shopName=name;

    }

        public void addProduct(){
            Scanner input=new Scanner(System.in);
            System.out.println("Enter product name:");
            String name=input.nextLine();
            System.out.println("Enter quantity:");
            int quantity=input.nextInt();
            System.out.println("Enter price:");
            double price=input.nextDouble();
            Product product =new Product(quantity,price,name);
            products[counter++]=product;
            System.out.println("Product added");

    }
    public void deleteProduct(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter product id");
        String id= input.nextLine();
        boolean productFound=false;

        for(int i=0;i<products.length;i++){
            if(products[i].getId().equals(id)){
                int currentQuantity= products[i].getQuantity();
                if(currentQuantity>0){
                    products[i].setQuantity(currentQuantity-1);
                    System.out.println("product deleted");
                    productFound=true;
                break;
                }else{
                        System.out.println("product is out of stock");

                    }
                }
                
            }
            if (productFound!=true){
                System.out.println("Product not found");
            }

        }
        public void dislpayProducts(){
            boolean productFound=false;
            Scanner input = new Scanner(System.in);{
                System.out.println("enter product id");
                String id =input.nextLine();
                for(int i=0;i<products.length;i++){
                    if(products[i].getId().equals(id)){
                        System.out.println("Product name:"+products[i].getName());
                        System.out.println("Product price:"+products[i].getPrice());
                        System.out.println("Product quantity:"+products[i].getQuantity());
                        productFound=true;
                        break;
                    }

                }
                if(productFound!=true){
                    System.out.println("Product not found");
                }

            }









        }







    }







