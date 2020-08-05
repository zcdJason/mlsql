import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author: Cock a doodle doo
 */
class TApp extends App{
  val conf = new SparkConf().setAppName("WordCount")
  val sc = new SparkContext(conf)

  val session = SparkSession.builder().appName("master").config(conf).getOrCreate();
}
