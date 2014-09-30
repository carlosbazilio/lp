import java.util._
import scala.language.implicitConversions

class DateHelper(number: Int) { 
	def days(when: String) : Date = {
		var date = Calendar.getInstance() 
		when match {
			case DateHelper.ago => date.add(Calendar.DAY_OF_MONTH, -number) 
			case DateHelper.from_now => date.add(Calendar.DAY_OF_MONTH, number) 
			case _ => date
		} 
		date.getTime()
	}
	
	def day(when: String) = days(when)
}

object DateHelper { 
	implicit def convertInt2DateHelper(number: Int) = new DateHelper(number)

	val ago = "ago" 
	val from_now = "from_now"
	
	def today : Date = {
		//Calendar.getInstance().getTime()
		0 days from_now
	}
	
	def tomorrow : Date = {
		1 days from_now
	}
	
	def yesterday : Date = {
		1 days ago
	}
}






