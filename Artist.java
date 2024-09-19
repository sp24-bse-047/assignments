public class Artist{
	private String name;

	public Artist(String n){
	this.name=n;
	}
	
	Artist(Artist artist){
	this.name=artist.getName();
	}
	

	public String getName(){
	return name;
	}

	public void display(){
	System.out.println("Artist Name:"+name);
	}


}