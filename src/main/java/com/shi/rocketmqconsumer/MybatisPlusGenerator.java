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
///**
// * @Method
// * @Author yakun.shi
// * @Description
// * @Return
// * @Date 2019/9/30 9:18
// */
//public class MybatisPlusGenerator {
//    public static void main(String[] args) {
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        //这里写你自己的java目录
//        gc.setOutputDir("D:\\javademo\\rocketmq-consumer\\src\\main\\java");
//        //是否覆盖
//        gc.setFileOverride(false);
//        gc.setActiveRecord(true);
//        // XML 二级缓存
//        gc.setEnableCache(false);
//        // XML ResultMap
//        gc.setBaseResultMap(true);
//        // XML columList
//        gc.setBaseColumnList(true);
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
//        dsc.setDriverName("com.mysql.jdbc.Driver");
//        dsc.setUsername("root");
//        dsc.setPassword("123456");
//        dsc.setUrl("jdbc:mysql://localhost:3306/rocket_mq?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC");
//        mpg.setDataSource(dsc);
//
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        // 此处可以修改为您的表前缀
////        strategy.setTablePrefix(new String[]{""});
//        //需要生成的表
//        strategy.setInclude(new String[]{"log",});
//        //表名生成策略
//        strategy.setNaming(NamingStrategy.underline_to_camel);
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
//        pc.setServiceImpl("com.shi.rocketmqconsumer.service.impl");
//        //本项目没用，生成之后删掉
//        pc.setController("com.shi.rocketmqconsumer.controller");
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
