package Objects.Flights;

public class Flight {	
private String airline;	
private int flightNumber;
private int flightCapacity;
private int seatsAvailable;
private int seatsOccupied;
private String originCity;
private String destinationCity;
private long departureTime;
private long arrivalTime;
private String departureDate;
private String arrivalDate;
private boolean isFull;
 
public Flight(){
	
}

public Flight(String airline, int flightNumber, String originCity, String destinationCity) {
	super();
	this.airline = airline;
	this.flightNumber = flightNumber;
	this.originCity = originCity;
	this.destinationCity = destinationCity;
}

public String getAirline() {
	return airline;
}

public void setAirline(String airline) {
	this.airline = airline;
}

public int getFlightNumber() {
	return flightNumber;
}

public void setFlightNumber(int flightNumber) {
	this.flightNumber = flightNumber;
}

public int getFlightCapacity() {
	return flightCapacity;
}

public void setFlightCapacity(int flightCapacity) {
	this.flightCapacity = flightCapacity;
}

public int getSeatsAvailable() {
	return seatsAvailable;
}

public void setSeatsAvailable(int seatsAvailable) {
	this.seatsAvailable = seatsAvailable;
}

public int getSeatsOccupied() {
	return seatsOccupied;
}

public void setSeatsOccupied(int seatsOccupied) {
	this.seatsOccupied = seatsOccupied;
}

public String getOriginCity() {
	return originCity;
}

public void setOriginCity(String originCity) {
	this.originCity = originCity;
}

public String getDestinationCity() {
	return destinationCity;
}

public void setDestinationCity(String destinationCity) {
	this.destinationCity = destinationCity;
}

public long getDepartureTime() {
	return departureTime;
}

public void setDepartureTime(long departureTime) {
	this.departureTime = departureTime;
}

public long getArrivalTime() {
	return arrivalTime;
}

public void setArrivalTime(long arrivalTime) {
	this.arrivalTime = arrivalTime;
}

public String getDepartureDate() {
	return departureDate;
}

public void setDepartureDate(String departureDate) {
	this.departureDate = departureDate;
}

public String getArrivalDate() {
	return arrivalDate;
}

public void setArrivalDate(String arrivalDate) {
	this.arrivalDate = arrivalDate;
}

public boolean isFull() {
	return isFull;
}

public void setFull(boolean isFull) {
	this.isFull = isFull;
}

@Override
public String toString() {
	return "Flight [airline=" + airline + ", flightNumber=" + flightNumber + ", flightCapacity=" + flightCapacity
			+ ", seatsAvailable=" + seatsAvailable + ", seatsOccupied=" + seatsOccupied + ", originCity=" + originCity
			+ ", destinationCity=" + destinationCity + ", departureTime=" + departureTime + ", arrivalTime="
			+ arrivalTime + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + ", isFull=" + isFull
			+ "]";
}



}
