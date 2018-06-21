package tao.twitter

import java.util.Properties

import com.typesafe.config.ConfigFactory
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper
import org.apache.flink.streaming.api.scala.{StreamExecutionEnvironment, _}
import org.apache.flink.streaming.connectors.twitter.TwitterSource
import tao.twitter.model.Twitter


object MainScala {
  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    val TWITTERSOURCE = ConfigFactory.load().getConfig("TWITTERSOURCE")

    val props = new Properties()
    props.setProperty(TwitterSource.CONSUMER_KEY, TWITTERSOURCE.getString("CONSUMER_KEY"))
    props.setProperty(TwitterSource.CONSUMER_SECRET, TWITTERSOURCE.getString("CONSUMER_SECRET"))
    props.setProperty(TwitterSource.TOKEN, TWITTERSOURCE.getString("TOKEN"))
    props.setProperty(TwitterSource.TOKEN_SECRET, TWITTERSOURCE.getString("TOKEN_SECRET"))

    val objectMapper = new ObjectMapper();

    val streamSource = env.addSource(new TwitterSource(props))
    streamSource.map(objectMapper.readValue(_, classOf[Twitter])).print()
    //.print()

    env.execute("flink scala twitter stream")
  }

}
