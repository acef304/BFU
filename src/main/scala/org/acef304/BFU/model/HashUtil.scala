package org.acef304.BFU.model

import java.io.PrintWriter
import upickle.default._


/**
  * Created by acef304 on 29/01/2017.
  */
object HashUtil {
  def writeHash(hash: FileHash, file: String) = {
    val pw = new PrintWriter(new java.io.File(file))
    pw.write(write(hash))
    pw.close
  }

  def readHash(file: String) = {
    read[FileHash](scala.io.Source.fromFile(file).getLines().mkString("\n"))
  }

  def compareHashes(source: FileHash, dest: FileHash) = {
    if (source.equals(dest)) {
      println("hashes are equal")
    } else {
      val goneParts = source.parts diff dest.parts
      val newParts = dest.parts diff source.parts
      println(s"gone parts(${goneParts.length})\n" + goneParts.mkString(", "))
      println(s"new parts(${newParts.length})\n" + newParts.mkString(", "))
    }
  }

}
