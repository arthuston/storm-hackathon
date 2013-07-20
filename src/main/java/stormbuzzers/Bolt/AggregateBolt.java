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
import storm.starter.bolt.Areas;

/**
 *
 */
public final class AggregateBolt extends BaseBasicBolt {
	List<Double> avgs;
	List<Double> sums;
	List<Double> counts;

    public AggregateBolt() { }

   @Override
   public void prepare(Map conf, TopologyContext context) {
      for (int idx = 0; idx < 100; idx++) { avgs.add(0.0); }
      for (int idx = 0; idx < 100; idx++) { sums.add(0.0); }
      for (int idx = 0; idx < 100; idx++) { counts.add(0.0); }
   }

   @Override public final void execute(Tuple tuple, BasicOutputCollector collector) {
      double lat = tuple.getDouble(0);
      double lng = tuple.getDouble(1);
      int score = tuple.getInteger(3);

      Areas ars = new Areas();
      int idx = ars.getArea(lng,lat);
      lat = ars.CITIES[idx].lat;
      lng = ars.CITIES[idx].lon;
      
      counts.set(idx, counts.get(idx) + 1);
      sums.set(idx, sums.get(idx) + score);
      avgs.set(idx, sums.get(idx) / counts.get(idx));
      collector.emit(new Values(lng,lat,counts.toArray(), avgs.toArray()));
   }

   @Override
   public void declareOutputFields(OutputFieldsDeclarer declarer) {
      declarer.declare(new Fields("longitude","latitude","count","score"));
   }

}
