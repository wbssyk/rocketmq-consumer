//package com.shi.rocketmqconsumer;
//
//import com.baomidou.mybatisplus.annotation.DbType;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.InjectionConfig;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
//import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class MybatisPlusGenerator {
//    public static void main(String[] args) {
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        gc.setOutputDir("F:\\rocketmq-consumer\\src\\main\\java");//这里写你自己的java目录
//        gc.setFileOverride(false);//是否覆盖
//        gc.setActiveRecord(true);
//        gc.setEnableCache(false);// XML 二级缓存
//        gc.setBaseResultMap(true);// XML ResultMap
//        gc.setBaseColumnList(true);// XML columList
//        gc.setAuthor("shiyakun");
//        mpg.setGlobalConfig(gc);
//
//        // 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setDbType(DbType.MYSQL);
//        dsc.setTypeConvert(new MySqlTypeConvert() {
//            // 自定义数据库表字段类型转换【可选】
//            @Override
//            public DbColumnType processTypeConvert(GlobalConfig globalConfig,String fieldType) {
//                return super.processTypeConvert(globalConfig,fieldType);
//            }
//        });
//        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        dsc.setUsername("root");
//        dsc.setPassword("syk123456");
//        dsc.setUrl("jdbc:mysql://localhost:3306/rocketmq?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC");
//        mpg.setDataSource(dsc);
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
////        strategy.setTablePrefix(new String[]{""});// 此处可以修改为您的表前缀
//        strategy.setInclude(new String[]{"messagetag1","messagetag2"});//需要生成的表
//        strategy.setNaming(NamingStrategy.underline_to_camel);//表名生成策略
//        //strategy.setEntityColumnConstant(true);
//        //strategy.setEntityBuilderModel(true);
//        //strategy.setCapitalMode(true);
//        //strategy.setEntityLombokModel(true);
//        strategy.setDbColumnUnderline(true);
//        mpg.setStrategy(strategy);
//
//        // 包配置
//        PackageConfig pc = new PackageConfig();
//        pc.setParent(null);
//        pc.setEntity("com.shi.rocketmqconsumer.entity");
//        pc.setMapper("com.shi.rocketmqconsumer.dao");
//        pc.setXml("com.shi.rocketmqconsumer.mapper");
//        pc.setService("com.shi.rocketmqconsumer.service");
//        pc.setServiceImpl("com.shi.rocketmqconsumer.impl");
//        pc.setController("com.shi.rocketmqconsumer.controller");    //本项目没用，生成之后删掉
//        mpg.setPackageInfo(pc);
//
//        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                Map<String, Object> map = new HashMap<>();
//                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
//                this.setMap(map);
//            }
//        };
//        mpg.setCfg(cfg);
//
//        // 执行生成
//        mpg.execute();
//
//        // 打印注入设置
//        System.err.println(mpg.getCfg().getMap().get("abc"));
//    }
//}
