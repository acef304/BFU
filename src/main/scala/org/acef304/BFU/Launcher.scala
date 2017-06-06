import org.acef304.BFU.model.{Conf, File}

object Launcher extends App {
  override def main(args: Array[String]) = {
    if (args.length > 0) {
      val file = new File(args(0), Conf())
      val hash = file.getFileHash
      println(s"File: ${args(0)} size: ${hash.length} hash: ${hash.total}\nparts:")
      hash.parts foreach println

      import upickle.default._
      println(write(hash))
    } else {
      println("None args")
    }
  }


}
