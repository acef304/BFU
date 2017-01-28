package org.acef304.BFU.model

import java.io.FileInputStream
import java.math.BigInteger

/**
  * Created by acef304 on 27/11/2016.
  */

class File(name: String, conf: Conf) {
  def initHash: Unit = {
    val t = new FileInputStream(name)
    //val size = (new java.io.File(name)).length()
    //var count = 0L
    val buff = new Array[Byte](conf.bufSize)
    while (t.read(buff) != -1) {
      println(checkSumToString(getChecksum(buff)))
    }
  }

  def getHash = {
    val stream = new FileInputStream(name)
    val buff = new Array[Byte](conf.bufSize)
    whi
  }


  def checkSumToString(bytes: Array[Byte]) = new BigInteger(1, bytes).toString()

  def getChecksum(buff: Array[Byte]) = {
    val m = java.security.MessageDigest.getInstance(conf.digest)
    m.update(buff, 0, buff.length)
    m.digest()
  }
}


class Hash(filename: String, length: Long, parts: Array[Array[Byte]])