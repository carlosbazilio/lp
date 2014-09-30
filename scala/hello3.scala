/*
public class Greet {
 	public static void main(String[] args) {
 		final String name = args.length == 1 ? args[0] : "world";
 		System.out.println("Hello " + name);
 	
 		try {
 			Thread.sleep(1000);
 		} catch(InterruptedException ex) {
 			//spend sleepless nights about what to do with this exception
 			//we're forced to handle
 		}
 	
 		System.out.println("good bye!");
 	}
}*/

val name = if (args.length == 1) args(0) else "world"
println("Hello " + name)
Thread.sleep(1000)
println("good bye!")

