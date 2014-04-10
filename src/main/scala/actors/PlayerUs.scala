package actors

import messages._
import akka.actor._
import akka.event.LoggingReceive

class PlayerUs extends Actor with ActorLogging {
  val receive = idle

  val friend = context.actorOf(Props[PlayerThem])
  val friend2 = context.actorOf(Props[PlayerThem])

  override def preStart() {
    println("Telling them where to stand")
    friend ! WhatToThrow("line")
    friend ! WhereToStand(20)
    friend2 ! WhatToThrow("grounder")
    friend2 ! WhereToStand(20)
  }

  def idle = LoggingReceive {
    case WaveHands(throwType) => {
      println("Seeing waving hands")

      if (throwType.equals("line")) {
        println("Throwing line drive ball")
        sender ! LineDriveBall

      } else {
        println("Throwing ground ball")
        sender ! GroundBall

      }

      println("Now waiting for ball")
      context.become(waitingForBall)
    }
  }

  def waitingForBall = LoggingReceive {
    case LineDriveBall => {
      println("Player Catching line drive ball")
      println("Throwing line ball")
      sender ! LineDriveBall
    }
    case GroundBall => {
      println("Catching ground ball")
      println("Throwing ground ball")
      sender ! GroundBall
    }
    case LobBall => {
      println("Catching lob ball")
      println("Throwing lob ball")
      sender ! LobBall
    }
    case WaveHands(throwType) => {
      println("Seeing waving hands")

      if (throwType.equals("line")) {
        println("Throwing line drive ball")
        sender ! LineDriveBall

      } else {
        println("Throwing ground ball")
        sender ! GroundBall

      }

     
    }
  }
}


