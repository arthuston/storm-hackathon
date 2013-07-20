package storm.starter.bolt;

import backtype.storm.tuple.Tuple;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import backtype.storm.task.TopologyContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import storm.starter.bolt.TcpServer;

/**
 *
 */
public final class UploadBolt extends BaseBasicBolt {
    public UploadBolt() { }
   
   @Override
   public final void execute(Tuple tuple, BasicOutputCollector collector) {
      double lat = tuple.getDouble(0);
      double lng = tuple.getDouble(1);
      int count = tuple.getInteger(2);
      int score = tuple.getInteger(3);
      TcpServer serv = new TcpServer();
	  try {
        serv.push(lat,lng,count,score);
	  } catch (Exception x) {
	    // ignore error
	  }
   }

   @Override
   public void declareOutputFields(OutputFieldsDeclarer declarer) { }

}
