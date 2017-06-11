import org.acef304.BFU.model.{Conf, File}

object Launcher extends App {
  override def main(args: Array[String]) = {
    args.length match {
      case 1 => {
        // compute and print hash for a given file
        val file = new File(args(0), Conf())
        val hash = file.getFileHash
        println(s"File: ${args(0)} size: ${hash.length} hash: ${hash.total}\nparts:")
        hash.parts foreach println
      }
      case 2 => {
        // compute hash of given file and store it in another file
        val file = new File(args(0), Conf())
        val hash = file.getFileHash
        import java.io.PrintWriter
        import upickle.default._
        val pw = new PrintWriter(new java.io.File(args(1)))
        pw.write(write(hash))
        pw.close
        println(s"File ${args(0)} hash has been written to ${args(1)} ")
      }
      case _ => launcherLoop
    }
  }

  def launcherLoop = {
    var repeat = true
    while (repeat) {
      print("bfu>")

      val tt = scala.io.StdIn.readLine
      if (tt.equals("exit"))
        repeat = false

      
    }
  }
}
