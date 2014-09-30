object Task {
 	def unapply(taskInfo : String) = {
 		val parts = taskInfo.split("---")
 		if(parts.size != 2) None else Some(parts(0), parts(1))
 	}
}

def processTask(detail : String) = {
 	detail match {
 		case Task(day, task) => println("Task for " + day + ":" + task)
 		case _ => println("Invalid task format")
 	}
}

processTask("Monday --- integrate with the payment system")
//Task for Monday : integrate with the payment system
processTask("Wednesday -- hack code with no tests")
//invalid task format
processTask("Frday --- discuss discount rates")
//Task for Frday : discuss discount rates

object DayOfWeek {
 	def unapply(day : String) = {
 		List("Sunday", "Monday", "Tuesday", "Wednesday", 
 			"Thursday", "Friday", "Saturday") contains day.trim
 	}
}

def processTaskImproved(detail : String) = {
 	detail match {
 		case Task(day @ DayOfWeek(), task) =>
 			println("Task for " + day + ":" + task)
 		case _ => println("Invalid task day or format")
 	}
}

processTaskImproved("Monday --- integrate with the payment system")
// Task for Monday : integrate with the payment system
processTaskImproved("Wednesday -- hack code with no tests")
// invalid task day or format
processTaskImproved("Frday --- discuss discount rates")
// invalid task day or format

