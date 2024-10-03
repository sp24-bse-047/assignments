public class Product{
    private String id;
    private int quantity;
    private String name;
    private double price;
    private static int counter=0;

    public Product(int quantity,double price,String name){
        this.id=String.format("%03d",++counter);
        this.quantity=quantity;
        this.price=price;
        this.name=name;
     }

        public Product(int quantity,double price){
            this(quantity,price,null);

        }
        public Product(int quantity){
            this(quantity,0,null);


        }
        public void setName(String name){
            this.name=name;

        }
        public void setPrice(double price){
            this.price=price;


        }
        public void setQuantity(int quantity){
            this.quantity=quantity;

        }
        public String getName(){
            return name;

        }
        public double getPrice(){
            return price;

        }
        public int getQuantity(){
            return quantity;

        }
        public String getId(){
            return id;
        }

            @Override
            public String toString(){
                return String.format("%s %s %f %d",id,name,price,quantity);

            }


            @Override
            public boolean equals(Object o){
                Product product=(Product)o;
                if(id.equals(product.getId()));
                return true;
            }





    }