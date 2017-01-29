name := "BFU"

version := "0.0.1"

scalaVersion := "2.11.8"

oneJarSettings

mainClass := Some("org.acef304.BFU.Launcher")

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "3.0.1" % "test"
  //"ch.qos.logback" %  "logback-classic" % "1.1.6",
)
    
