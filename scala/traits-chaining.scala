case class Person(first: String, last: String) {
 	override def toString = first + " " + last
}

abstract class Checker {
 	def check(applicant : Person) : Boolean
}

def evaluateApplicant(applicant : Person, checker: Checker) = {
 	println("Received application for " + applicant)
 	val result = if(checker.check(applicant)) "approved" else "disapproved"
 	println("Application " + result)
}

class EducationChecker extends Checker {
 	override def check(applicant : Person) = {
 		println("checking education...")
 		//...
 		applicant.last.length > 1
 	}
}

val john = Person("John", "X")
evaluateApplicant(john, new EducationChecker)

trait CreditChecker extends Checker {
 	abstract override def check(applicant : Person) = {
 		println("checking credit...")
 		//...
 		super.check(applicant) && (applicant.last.length > 1)
 	}
}

trait CrimeChecker extends Checker {
 	abstract override def check(applicant : Person) = {
 		println("checking criminal records...")
 		//...
 		super.check(applicant) && (applicant.last.length > 1)
 	}
}

evaluateApplicant(Person("Mark", "Who"), new EducationChecker with CrimeChecker 
	with CreditChecker)

