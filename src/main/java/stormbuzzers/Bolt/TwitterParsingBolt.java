package storm.starter.bolt;

import backtype.storm.tuple.Tuple;
import twitter4j.Status;
import twitter4j.Place;
import twitter4j.GeoLocation;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

/**
 *
 */
public final class TwitterParsingBolt extends BaseBasicBolt {
    public TwitterParsingBolt() { }

   @Override
   public final void execute(Tuple tuple, BasicOutputCollector collector) {
      GeoLocation loc = (GeoLocation) tuple.getValue(0);
      Place plc = (Place) tuple.getValue(1);
      String tweettext = (String) tuple.getValue(2);
      if (plc != null) { /* TODO */ }
      double lat = loc.getLatitude();
      double lng = loc.getLongitude();
      collector.emit(new Values(lng,lat,tweettext));
   }
   
   @Override
   public void declareOutputFields(OutputFieldsDeclarer declarer) {
      declarer.declare(new Fields("longitude","latitude","text"));
   }

}
