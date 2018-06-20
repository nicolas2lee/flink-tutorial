package tao.twitter.model

import org.scalatest.FunSuite

class TwitterTest extends FunSuite {
  def fixture = {
    val fileInputStream = getClass.getResourceAsStream("/twitter.json")
    //Source.fromInputStream(fileInputStream).collect()
  }

  test("should parse a json string into a twitter object") {

  }
}
