public class ArtWork{
	private String titleName;
	private int year;
	Artist a;

	Artwork(Artwork artwork){
	this.titleName=artwork.getTitleName();
	this.year=artwork.getYear();
	this.a=a;
		}	

	Artwork(Artwork artwork){
	this.titleName=artwork.getTitleName();
	this.year=artwork.getYear();
	this.a=new Artist (Artwork.getA());
		}



	public Artwork(String name,int year,Artist a){
	this.titleName=name;
	this.year=year;
	this.a=a;
	}

	public Address(String name,int year){
	this.name=name;
	this.year=year;
	this.a="Unknown Artist";
	}

	public String getTitleName(){
	return titleName;
	}
	
	public int getYear(){
	return year;
	}
	
	public Artist getA(){
	return a;
	}

	public void display(){
	System.out.println("Title Name:"+titleName);
	System.out.println("Year:"+year);
	a.display();
	}





}