package sleepingbarber

import scala.actors.Actor 
import scala.actors.Actor._

case object Haircut 

class Customer(val id: Int) extends Actor {
	var shorn = false

	def act() = { 
		loop {
			react { 
				case Haircut => { 
					shorn = true 
					println("[c] customer " + id + " got a haircut")
				}
			}
		}
	}
}

import scala.util.Random
class Barber extends Actor { 
	private val random = new Random()
	
	def helpCustomer(customer: Customer) { 
		if (self.mailboxSize >= 3) {
			println("[b] not enough seats, turning customer " + customer.id + " away") 
		} else {
			println("[b] cutting hair of customer " + customer.id) 
			Thread.sleep(100 + random.nextInt(400)) 
			customer ! Haircut
		}
	}
	
	def act() { 
		loop {
			react {
				case customer: Customer => helpCustomer(customer)
			}
		}
	}
}


class Shop extends Actor { 
	val barber = new Barber() 
	barber.start
	
	def act() { 
		println("[s] the shop is open")
	
		loop { 
			react {
				case customer: Customer => barber ! customer
			}
		}
	}
}

import scala.collection.{immutable, mutable}

object BarbershopSimulator { 
	private val random = new Random() 
	private val customers = new mutable.ArrayBuffer[Customer]() 
	private val shop = new Shop()

	def generateCustomers { 
		for (i <- 1 to 10) {
			val customer = new Customer(i) 
			customer.start() 
			customers += customer
		} 
		println("[!] generated " + customers.size + " customers")
	}
	
	// customers arrive at random intervals
	def trickleCustomers { 
		for (customer <- customers) {
			shop ! customer 
			Thread.sleep(random.nextInt(450))
		}
	}

	def tallyCuts { 
		// wait for any remaining concurrent actions to complete 
		Thread.sleep(2000)

		val shornCount = customers.filter(c => c.shorn).size 
		println("[!] " + shornCount + " customers got haircuts today")
	}

	def main(args: Array[String]) { 
		println("[!] starting barbershop simulation") 
		shop.start()

		generateCustomers 
		trickleCustomers 
		tallyCuts
		
		System.exit(0)
	}
}

