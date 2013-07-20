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

/**
 *
 */
public final class AggregateBolt extends BaseBasicBolt {
    public SemanticBolt() { }

   @Override
   public void prepare(Map conf, TopologyContext context) {
      List<List<int>> avgs = new List<List<int>>(100);
      List<int>
   }
   
   @Override
   public final void execute(Tuple tuple, BasicOutputCollector collector) {
      double lat = tuple.getDouble(0);
      double lng = tuple.getDouble(1);
      int score = tuple.getInt(3);

      Areas ars = new Areas();
      lat = getBinLat(lng,lat);
      lng = getBinLng(lng,lat);
      idx = getIndex(lng,lat);

      collector.emit(new Values(lng,lat,,score));
   }

   @Override
   public void declareOutputFields(OutputFieldsDeclarer declarer) {
      declarer.declare(new Fields("longitude","latitude","polarity","score"));
   }

}
