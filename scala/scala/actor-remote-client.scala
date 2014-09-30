import scala.actors._
import scala.actors.Actor._
import scala.actors.remote._
import scala.actors.remote.RemoteActor._

val myRemoteActor = select(Node("localhost", 8000), 'myActor)
myRemoteActor ! "Hello!"

