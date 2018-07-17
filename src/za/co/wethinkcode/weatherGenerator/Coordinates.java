package za.co.wethinkcode.weatherGenerator;
public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;


    public Coordinates(int longitude, int latitude, int height){
    	this.setLongitude(longitude);
        this.setHeight(height);
        this.setLatitude(latitude);
    }

    public void setLongitude(int longitude) {
		
    	this.longitude = longitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	
	public void setHeight(int height) {
		if (this.height < 0)
            this.height = 0;
		else if (this.height > 100)
            this.height = 100;
		else
			this.height = height;
	}
	
	public int getLongitude(){
        return longitude;    
    }

	public int getLatitude(){
        return latitude;
    }

    public int getHeight(){
        return height;
    }
}