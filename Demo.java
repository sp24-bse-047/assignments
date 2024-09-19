public class Demo{

	public static void main(String []args){
	Artist a=new Artist("Huzaifa liaquat");
	
	Artwork w=new Artwork("Marvels",2012,a);
	Artwork w2=new Artwork("Marvels",2013);
	

	Artist a2=new Artist(a);
	

	Artwork.display();		
	}



}