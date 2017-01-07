import org.acef304.BFU.model.{Conf, File}

object Launcher extends App {
  override def main(args: Array[String]) = {
    if (args.length > 0) {
      initHash(args(0))
    } else {
      println("None args")
    }
  }


  def initHash(filename: String): Unit = {
    val file = new File(filename, Conf())
    file.initHash
  }

}
