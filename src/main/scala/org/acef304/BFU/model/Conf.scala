package org.acef304.BFU.model

/**
  * Created by acef304 on 27/11/2016.
  */
case class Conf(bufSize: Int = 10*1024*1024, bytesPerDigest: Int = 8, digest: String = "SHA-1")

object Conf {
  lazy val default = Conf()
  def apply: Conf = default
}