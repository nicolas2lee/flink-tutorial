package tao.twitter.model

import java.time.LocalDateTime

class Twitter(created: LocalDateTime, text: String, source: String) {
  val entities: List[Entity] = Nil

  override def toString: String = "created=%s, text=%s, source=%s, entities=%s".format(created, text, source)

  class Entity {
    val hashtags: List[String] = Nil
    val urls: List[String] = Nil
    val user_mentions: List[String] = Nil
    val symbols: List[String] = Nil

    override def toString: String = "hashtags=%s, urls=%s, user_mentions=%s, symbols=%s".format(hashtags, urls, user_mentions, symbols)
  }

}
