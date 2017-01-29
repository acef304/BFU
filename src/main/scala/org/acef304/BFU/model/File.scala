package org.acef304.BFU.model

import java.io.FileInputStream
import java.math.BigInteger

/**
  * Created by acef304 on 27/11/2016.
  */

class File(name: String, conf: Conf) {
  type checksum = Array[Byte]
  type buff = Array[Byte]

  def initHash: Unit =
    getHash.parts.foreach(p => println(checkSumToString(p)))

  def getChecksum(buff: Array[Byte]) = {
    val m = java.security.MessageDigest.getInstance(conf.digest)
    m.update(buff, 0, buff.length)
    m.digest()
  }

  def getHashArray(stream: FileInputStream, buff: buff, acc: List[checksum]): List[checksum] = {
    if (stream.read(buff) != -1)
      getHashArray(stream, buff, getChecksum(buff) :: acc)
    else
      acc
  }

  def getHash = FileHash(new java.io.File(name).length(), getHashArray(new FileInputStream(name), new buff(conf.bufSize), Nil))

  def checkSumToString(bytes: checksum) = new BigInteger(1, bytes).toString()
}

case class FileHash(length: Long, parts: List[Array[Byte]])