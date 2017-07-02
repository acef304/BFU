package org.acef304.BFU.util

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by acef304 on 12/06/2017.
  */
object ParlUtil {

  def computeTwo[A, B](fun1: () => A, fun2: () => B): (A, B) = {
    val fut1 = Future { fun1() }
    val fut2 = Future { fun2() }
    val comb = for { r1 <- fut1; r2 <- fut2 } yield (r1, r2)
    Await.result(comb, 10 second)
  }

}
