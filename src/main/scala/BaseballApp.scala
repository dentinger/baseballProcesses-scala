import actors._
import akka.actor._
import akka.event.LoggingReceive
import akka.pattern.gracefulStop
import scala.concurrent._
import scala.concurrent.duration._

object BaseballApp extends App {
  val actorRef = ActorSystem("baseallActors").actorOf(Props[PlayerUs])
   
}

