/*
public class Car {
 	private final int year;
 	private int miles;
 	
 	public int getYear() { return year; }
 	public int getMiles() { return miles; }
 	public void setMiles(int theMiles) { miles = theMiles; }
 	
 	public Car(int theYear, int theMiles) {
 		year = theYear;
 		miles = theMiles;
 	}
}
*/

class Car(val year : Int, var miles : Int)

class Car2(val year : Int) {
	private var milesDriven = 0
	
	def miles = milesDriven
	
	def drive(distance : Int) = milesDriven += distance
}

val car = new Car(2011, 0)

println(car.year + " " + car.miles)

