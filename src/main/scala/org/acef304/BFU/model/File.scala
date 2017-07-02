package org.acef304.BFU.model

import java.io.FileInputStream
import java.math.BigInteger
import java.security.MessageDigest

import org.acef304.BFU.util.ParlUtil

/**
  * Created by acef304 on 27/11/2016.
  */

class File(name: String, conf: Conf) {
  type checksum = Array[Byte]
  type buff = Array[Byte]
  val fileLength = new java.io.File(name).length()

  private def defaultMessageDigest = java.security.MessageDigest.getInstance(conf.digest)

  private def updateDigest(buff: Array[Byte], length: Int, messageDigest: MessageDigest = defaultMessageDigest) = {
    messageDigest.update(buff, 0, length)
    messageDigest
  }

  private def getHashArray(stream: FileInputStream, buff: buff, acc: List[checksum], progress: Long = 0,
                   d: MessageDigest = defaultMessageDigest): (checksum, List[checksum]) = {
    val readedBytes = stream.read(buff)
    print(s"\r$progress \\ $fileLength (${ progress * 100 / fileLength }%)")
    if (readedBytes != -1) {
      val hashComposition = ParlUtil.computeTwo(
        () => updateDigest(buff, readedBytes).digest(),
        () => updateDigest(buff, readedBytes,d))
      getHashArray(stream, buff, hashComposition._1 :: acc, progress + readedBytes, hashComposition._2)
    }
    else
      (d.digest, acc)
  }

  def checkSumToString(bytes: checksum) = new BigInteger(1, bytes).toString()

  def getFileHash = {
    val fileHash = getHashArray(new FileInputStream(name), new buff(conf.bufSize), Nil)
    FileHash(fileLength, Hex.valueOf(fileHash._1), fileHash._2 map Hex.valueOf)
  }
}

object Hex {
  def valueOf(buf: Array[Byte]): String = buf.map("%02X" format _).mkString
}

case class FileHash(length: Long, total: String, parts: List[String])