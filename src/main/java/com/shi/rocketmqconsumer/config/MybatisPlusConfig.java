package com.shi.rocketmqconsumer.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.shi.rocketmqconsumer.dao")
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//        paginationInterceptor.setLocalPage(true);// 开启 PageHelper 的支持
//        return paginationInterceptor;
//    }

//    @Bean
//    public PerformanceInterceptor performanceInterceptor() {
//        return new PerformanceInterceptor();
//    }
//
//    @Bean(name = "db1")
//    @ConfigurationProperties(prefix = "spring.datasource.druid.db1" )
//    public DataSource db1 () {
//        return DruidDataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "db2")
//    @ConfigurationProperties(prefix = "spring.datasource.druid.db2" )
//    public DataSource db2 () {
//        return DruidDataSourceBuilder.create().build();
//    }
//    /**
//     * 动态数据源配置
//     * @return
//     */
//    @Bean
//    @Primary
//    public DataSource multipleDataSource (@Qualifier("db1") DataSource db1,
//                                          @Qualifier("db2") DataSource db2 ) {
//        DynamicDataSource dynamicDataSource = new DynamicDataSource();
//        Map< Object, Object > targetDataSources = new HashMap<>();
//        targetDataSources.put(DBTypeEnum.db1.getValue(), db1 );
//        targetDataSources.put(DBTypeEnum.db2.getValue(), db2);
//        dynamicDataSource.setTargetDataSources(targetDataSources);
//        //设置默认数据源为 db1
//        dynamicDataSource.setDefaultTargetDataSource(db1);
//        return dynamicDataSource;
//    }
//
//    @Bean("sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
//        //配置数据源
//        sqlSessionFactory.setDataSource(multipleDataSource(db1(),db2()));
//        //配置扫描包地址
//        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*Mapper.xml"));
//
//        MybatisConfiguration configuration = new MybatisConfiguration();
//        //configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
//        configuration.setJdbcTypeForNull(JdbcType.NULL);
//        configuration.setMapUnderscoreToCamelCase(true);
//        configuration.setCacheEnabled(false);
//        sqlSessionFactory.setConfiguration(configuration);
//        sqlSessionFactory.setPlugins(new Interceptor[]{ //PerformanceInterceptor(),OptimisticLockerInterceptor()
//                paginationInterceptor()
//        });
//        sqlSessionFactory.setGlobalConfig(globalConfiguration());
//        return sqlSessionFactory.getObject();
//    }
//
//    @Bean
//    public GlobalConfiguration globalConfiguration() {
//        GlobalConfiguration conf = new GlobalConfiguration(new LogicSqlInjector());
//        conf.setLogicDeleteValue("-1");
//        conf.setLogicNotDeleteValue("1");
//        conf.setIdType(0);
//        conf.setMetaObjectHandler(new MyMetaObjectHandler());
//        conf.setDbColumnUnderline(true);
//        conf.setRefresh(true);
//        return conf;
//    }

}
