/*
/////////////////////////////
// Customer and Stock encryption without traits
object Encryptor {
 	def encrypt(data : String) = {
 		// some complex logic to encrypt the data
 		data.reverse
 	}
}

class CustomerOld(val firstName : String, lastName : String) {
 	//...
 	override def toString = "Details for customer " + firstName + " - " + lastName
 	
 	def encrypt = Encryptor.encrypt(toString)
}
 	
class StockOld(override val name : String) extends Security(name) {
 	override def toString = "Details for stock " + name
 	
 	def encrypt = Encryptor.encrypt(toString)
}

/////////////////////////////
// Customer and Stock encryption WITH traits

trait EncryptOld {
 	def encrypt : String
}

// Use scalac and javap (disassemble Java bytecodes) tools to verify that
//Scala translates traits without implementations into Java interfaces

> scalac Encrypt.scala
> javap Encrypt
Compiled from "Encrypt.scala"
public interface Encrypt{
 	public abstract java.lang.String encrypt();
}
*/

trait Encrypt {
 	def encrypt = {
 		// some complex logic to encrypt the data
 		toString.reverse
 	}
}

class Customer(val firstName : String, lastName : String) extends Encrypt {
 	override def toString = "Details for customer " + firstName + " - " + lastName
}

class Security(val name : String)
class Stock(override val name : String) extends Security(name) with Encrypt {
 	override def toString = "Details for stock " + name
}

val stock = new Stock("XYZ")
println(stock.encrypt)

/////////////////////////////
// Scala also allows traits applied to instances

class CheckingAccount(val number : Int) {
 	override def toString = "Details for account " + number
}

val anAccount = new CheckingAccount(1)
val secretAccount = new CheckingAccount(2) with Encrypt
println(secretAccount.encrypt)

