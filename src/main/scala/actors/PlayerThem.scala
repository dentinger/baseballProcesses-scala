package actors

import messages._
import akka.actor._
import akka.event.LoggingReceive

class PlayerThem extends Actor with ActorLogging {
  val receive = idle
  val throwType = ""
  def idle = LoggingReceive {
    case WhatToThrow(ballType) => {
      println("GOing to a ball type of ${ballType}")

      if (ballType.equals("line")) {
        context.become(waitForLineDistance)
      } else if (ballType.equals("grounder")) {
        context.become(waitForGroundDistance)
      } else {
        context.become(waitForLineDistance)
      }
    }
  }

  def waitForLineDistance = LoggingReceive {

    case WhereToStand(distance) => {
      println("Reached ${distance} meters way, waving hands")
      sender ! WaveHands("line")
      println("Now waiting for ball")
      context.become(waitingForBall)
    }

  }
  def waitForGroundDistance = LoggingReceive {

    case WhereToStand(distance) => {
      println("Reached ${distance} meters way, waving hands")
      sender ! WaveHands("grounder")
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
  }
}