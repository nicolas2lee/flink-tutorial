package tao.twitter;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.twitter.TwitterSource;

import java.util.Properties;

/**
 * Created by xinrui on 06/06/2018.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        Properties props = new Properties();
        props.setProperty(TwitterSource.CONSUMER_KEY, "yourKey");
        props.setProperty(TwitterSource.CONSUMER_SECRET, "yourKey");
        props.setProperty(TwitterSource.TOKEN, "yourKey");
        props.setProperty(TwitterSource.TOKEN_SECRET, "yourKey");

        DataStream<String> twitterStream = env.addSource(new TwitterSource(props));

        twitterStream.print();

        env.execute("Flink twitter stream");
    }
}
