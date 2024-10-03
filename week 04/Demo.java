import java.util.Scanner;
public class Demo {
     
    public static void main(String[] args) {
    Shop s1 = new Shop("MArvels","Sookkalan");
    int chooice=-1;
    while (chooice!=0) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to add product");
        System.out.println("Enter 2 to delete product");
        System.out.println("Enter 3 to display products");
        System.out.println("Enter 0 to  exit");
        chooice = input.nextInt();
        switch (chooice) {
        case 1:
        s1.addProduct();
            break;
        case 2:
        s1.deleteProduct();
        break;
        case 3:
        s1.dislpayProducts();
        break;
        case 0:
        System.out.println("PROGRAM TERMINATED");
        break;
        
        default:
            break;
    }
}
    }
}
