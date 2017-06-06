package org.acef304.BFU.model

import java.io.{BufferedOutputStream, FileInputStream, FileOutputStream}
import java.nio.ByteBuffer

/**
  * Created by acef304 on 29/01/2017.
  */
object HashUtil {
  def writeHashToFile(file: String, hash: FileHash) = {
    val bos = new BufferedOutputStream(new FileOutputStream(file))
    bos.write(toByteArray(hash))
    bos.close()
  }

  def partOffset(i: Int) = 8 + i * Conf().bytesPerDigest

  def readHashFromFile(file: String) = {
    val fileSize = new java.io.File(file).length
    val stream = new FileInputStream(file)
    val buffer = ByteBuffer.allocate(fileSize.toInt)
    stream.read(buffer.array())
    val length = buffer.getLong(0)
    val partsCount = (fileSize.toInt - 8) / Conf().bytesPerDigest
    val parts = for (i <- 1 to partsCount) yield buffer.array.slice(partOffset(i), partOffset(i + 1))
    //FileHash(length, parts.toList)
  }

  def toByteArray(hash: FileHash) = {
    val size = 8 * hash.parts.length * Conf().bytesPerDigest
    val bb  = ByteBuffer.allocate(size)
    bb.putLong(hash.length)

    var offset = 8
    for (part <- hash.parts) {
      //bb.put(part, offset, Conf().bytesPerDigest)
      offset += Conf().bytesPerDigest
    }
    bb.array()
  }
}
