package storm.starter.bolt;

import backtype.storm.tuple.Tuple;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import backtype.storm.task.TopologyContext;

import com.semantria.Session;
import com.semantria.mapping.Document;
import com.semantria.mapping.output.DocAnalyticData;
import com.semantria.mapping.output.DocEntity;
import com.semantria.mapping.output.DocTheme;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 */
public final class SemanticBolt extends BaseBasicBolt {
   String key = "29496fd3-8ddd-4bcb-a543-80d5863797a3";
   String sec = "7d23a3a6-a769-4200-999b-1011c6b89761";
   Session session;
   
    public SemanticBolt() { }

   @Override
   public void prepare(Map conf, TopologyContext context) {
      session = Session.createSession(key, sec, true);
      //      session.setCallbackHandler(new CallbackHandler());
   }
   
   @Override
   public final void execute(Tuple tuple, BasicOutputCollector collector) {
      double lat = tuple.getDouble(0);
      double lng = tuple.getDouble(1);
      String tweettext = (String) tuple.getValue(2);
      int score = 0;
      try {
         String uid = UUID.randomUUID().toString();
         if ( session.queueDocument( new Document( uid, tweettext )) != 202) {
            System.out.println("ERROR! Submitting semantria text");
         }
   
         Thread.sleep(1000);
         List<DocAnalyticData> temp = session.getProcessedDocuments();
         for(DocAnalyticData doc : temp) {
            if (doc.getThemes() != null) {
               for(DocTheme theme : doc.getThemes()) {
                  collector.emit(new Values(lng,lat,theme.getSentimentPolarity(),theme.   getSentimentScore()));
               }
            }
         }
      } catch (Exception ex) {
         // Do nothing
      }
   }
   
   @Override
   public void declareOutputFields(OutputFieldsDeclarer declarer) {
      declarer.declare(new Fields("longitude","latitude","polarity","score"));
   }

}
