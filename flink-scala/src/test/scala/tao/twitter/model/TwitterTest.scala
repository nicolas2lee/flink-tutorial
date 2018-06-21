package tao.twitter.model

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper
import org.scalatest.FunSuite

import scala.io.Source

class TwitterTest extends FunSuite {
  def fixture = new {
    val fileInputStream = getClass.getResourceAsStream("/twitter.json")
    val jsonString = Source.fromInputStream(fileInputStream).toList.mkString("")
  }

  test("should parse a json string into a twitter object") {
    val f = fixture
    val mapper = new ObjectMapper(); // can reuse, share globally
    val twitter: Twitter = mapper.readValue(f.jsonString, classOf[Twitter]);
    println(twitter)
  }
}
