import java.io.{File, FileWriter}

import org.acef304.BFU.model.HashUtil
import org.scalatest.FunSuite

import scala.util.Random

/**
  * Created by acef304 on 29/01/2017.
  */
class BFUSuite extends FunSuite {
  test("Empty offset test") {
    assert(HashUtil.partOffset(0) == 8)
  }
}

object Utils {
  def cleanRandomFile = {
    new File("test.data").delete()
  }

  def generateRandomFile = {
    val name = "test.data"
    val size = Random.nextDouble() * 10 * 1024 * 1024 toInt
    val testData = Random.nextString(size)
    (new FileWriter(name)).write(testData)
  }
}
