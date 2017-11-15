package Objects.Citys;


public class City {
private String cityName;
private String Location;
private String cityId;


	public City(){
	cityName = "Atlanta";
	Location = "Georgia";
	cityId = "ATL";
	
	}
	
	public City(String a, String b, String c) {
		cityName =a;
		Location = b;
		cityId = c;
	}

	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	
	@Override
	public String toString() {
		return "City Name: " + cityName + "\nLocation: " + Location + "\nCity ID: " + cityId +"";
	}

}
