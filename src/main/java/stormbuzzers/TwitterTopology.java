package storm.starter;

import storm.starter.spout.TwitterLocationSpout;
import storm.starter.bolt.TwitterParsingBolt;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.StormSubmitter;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import java.util.HashMap;
import java.util.Map;

/**
 * This topology demonstrates Storm's stream groupings and multilang capabilities.
 */
public class TwitterTopology {
    
    public static void main(String[] args) throws Exception {
       Config conf = new Config();
       conf.setDebug(true);
       TopologyBuilder builder = new TopologyBuilder();
       
       builder.setSpout("tweetspout", new TwitterLocationSpout(), 1);
       builder.setBolt("tweetparse", new TwitterParsingBolt(), 1)
          .shuffleGrouping("tweetspout");
       builder.setBolt("semantics", new SemanticBolt(), 1)
         .shuffleGrouping("tweetparse");
       builder.setBole("aggregate", new AggregateBolt(), 1)
         .shuffleGrouping("semantics");
       
         StormSubmitter.submitTopology(args[0], conf, builder.createTopology());
         LocalCluster cluster = new LocalCluster();
         cluster.submitTopology("simpletweetstuff", conf, builder.createTopology());
         Thread.sleep(10000);
         cluster.shutdown();
    }
}
