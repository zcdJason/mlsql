/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package streaming.core

import org.apache.spark.sql.SparkSession

/**
  * Created by allwefantasy on 30/3/2017.
 *  开发调试入口
  */
object LocalSparkServiceApp {
  def main(args: Array[String]): Unit = {
    StreamingApp.main(Array(
      "-streaming.master", "local[*]",
      "-streaming.name", "god",
      "-streaming.rest", "true",
      "-streaming.thrift", "false",
      "-streaming.platform", "spark",
      //"-spark.mlsql.enable.max.result.limit", "true",
      //"-spark.mlsql.restful.api.max.result.size", "7",
      //"-spark.mlsql.enable.datasource.rewrite", "true",
      //"-spark.mlsql.datasource.rewrite.implClass", "streaming.core.datasource.impl.TestRewrite",
      //"-streaming.job.file.path", "classpath:///test/empty.json",
      "-streaming.spark.service", "true",
      "-streaming.job.cancel", "true",
      "-streaming.ps.enable", "true",

      "-spark.sql.hive.thriftServer.singleSession", "false",
      "-streaming.enableHiveSupport", "true",

      "-streaming.rest.intercept.clzz", "streaming.rest.ExampleRestInterceptor",

      //用Local模式部署成API时，请开启该选项，此参数会导致hive失效（使用hive表没有效果，会提示找不到表），默认sparkcontext会被替换  |false|
      //这个模式主要是为了对外提供毫秒级的预测服务
      "-streaming.deploy.rest.api", "false",

      "-spark.driver.maxResultSize", "2g",
      "-spark.serializer", "org.apache.spark.serializer.KryoSerializer",
      "-spark.sql.codegen.wholeStage", "true",
      "-spark.kryoserializer.buffer.max", "2000m",
//      "-spark.mlsql.enable.runtime.select.auth", "true",
      "-streaming.driver.port", "9003",
      "-spark.files.maxPartitionBytes", "10485760",
      "-spark.sql.shuffle.partitions", "1",
      "-spark.hadoop.mapreduce.job.run-local", "true",
      //添加datalake路径，这个路径配置插件的时候也需要使用（插件的信息和有些元信息存储的位置，如果没有配置数据库，默认使用它来记录信息）
      "-streaming.datalake.path","/tmp/datahouse",
      "-streaming.plugin.clzznames","tech.mlsql.plugins.ds.MLSQLExcelApp" //配置excel插件主类

      //"-streaming.sql.out.path","file:///tmp/test/pdate=20160809"

      //"-streaming.jobs","idf-compute"
      //"-streaming.sql.source.path","hdfs://m2:8020/data/raw/live-hls-formated/20160725/19/cdn148-16-52_2016072519.1469444764341"
      //"-streaming.driver.port", "9005"
      //"-streaming.zk.servers", "127.0.0.1",
      //"-streaming.zk.conf_root_dir", "/streamingpro/jack"
    ))
  }
}
