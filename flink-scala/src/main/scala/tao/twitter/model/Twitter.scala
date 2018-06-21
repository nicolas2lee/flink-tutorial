package tao.twitter.model

import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.annotation.{JsonIgnoreProperties, JsonProperty}

@JsonIgnoreProperties(ignoreUnknown = true)
class Twitter(@JsonProperty("created_at") val created: String,
              @JsonProperty("text") val text: String,
              @JsonProperty("source") val source: String) {
  val entities: List[Entity] = Nil

  override def toString: String = "created=%s, text=%s, source=%s, entities=%s".format(created, text, source, entities)

  class Entity {
    val hashtags: List[String] = Nil
    val urls: List[String] = Nil
    val user_mentions: List[String] = Nil
    val symbols: List[String] = Nil

    override def toString: String = "hashtags=%s, urls=%s, user_mentions=%s, symbols=%s".format(hashtags, urls, user_mentions, symbols)
  }

}
