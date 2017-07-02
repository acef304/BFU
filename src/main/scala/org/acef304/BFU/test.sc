import org.acef304.BFU.util.ParlUtil

val start = System.currentTimeMillis
def fromStart = System.currentTimeMillis - start

def longComp(name: String) = {
  println(s"Long computation '$name' has been started at $fromStart")
  Thread.sleep(2000)
  println(s"Long computation '$name' has been ended at $fromStart")
}

ParlUtil.computeTwo(
  () => longComp("lolka"),
  () => longComp("lolka2")
)