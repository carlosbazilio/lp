import scala.actors._
import scala.actors.Actor._
import scala.actors.remote._
import scala.actors.remote.RemoteActor._

/** @author Connor Doyle */

// Remote messages must be serializable.
// The easist way to do this is to wrap
// them with a case class
case class Message(text: String)

abstract class PingPongActor extends Actor with App {
    val pingPort = 9000
    val pongPort = 9001
    val localHost = "localhost"
    val remoteHost = "localhost"
    val delay = 1000
    classLoader = getClass().getClassLoader() // hack!
    start

    // this method consumes all pending messages
    // the library should have implemented an atomic 
    // receiveAndClear operation
    def clear: Unit = receiveWithin(0) {
        case TIMEOUT => ()
        case _ => clear
    }
}

object Ping extends PingPongActor {

    // result of select already lazy, but explicit lazy conveys
    // semantics clearly
    lazy val pong = select(Node(localHost, pongPort), 'pong)

    def act = {
        alive(pingPort)
        register('ping, self)
        loop {
            pong ! Message("ping")
            receiveWithin(delay * 2) {
                case Message(text: String) => {
                    clear
                    println("received: "+text)
                    Thread.sleep(delay) // wait a while
                }
                case TIMEOUT => println("ping: timed out!")
            }
        }
    }
}

object Pong extends PingPongActor {

    lazy val ping = select(Node(remoteHost, pingPort), 'ping)

    def act = {
        alive(pongPort)
        register('pong, self)
        loop {
            receiveWithin(delay * 2) {
                case Message(text: String) => {
                    println("received: "+text)
                    Thread.sleep(delay) // wait a while
                    clear
                    ping ! Message("pong")
                }
                case TIMEOUT => println("pong: timed out")
            }
        }
    }
}

