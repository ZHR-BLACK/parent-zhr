package com.zhr.db.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhr
 * mybatisplus配置类
 */
@Configuration
@MapperScan("com.zhr.db.dao.mapper")
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

//    /**
//     * 这里全部使用mybatis-autoconfigure 已经自动加载的资源。不手动指定 配置文件和mybatis-boot的配置文件同步
//     *
//     * @return
//     * @throws IOException
//     */
//    @Bean
//    public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean() throws IOException {
//        MybatisSqlSessionFactoryBean mybatisPlus = new MybatisSqlSessionFactoryBean();
//        mybatisPlus.setDataSource(dataSource);
//        mybatisPlus.setVfs(SpringBootVFS.class);
//        String configLocation = this.properties.getConfigLocation();
//        if (StringUtils.isNotBlank(configLocation)) {
//            mybatisPlus.setConfigLocation(this.resourceLoader.getResource(configLocation));
//        }
//        mybatisPlus.setConfiguration(properties.getConfiguration());
//        mybatisPlus.setPlugins(this.interceptors);
//        MybatisConfiguration mc = new MybatisConfiguration();
//        mc.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
//        mc.setMapUnderscoreToCamelCase(false);// 数据库和java都是驼峰，就不需要
//        mybatisPlus.setConfiguration(mc);
//        if (this.databaseIdProvider != null) {
//            mybatisPlus.setDatabaseIdProvider(this.databaseIdProvider);
//        }
//        mybatisPlus.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
//        mybatisPlus.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
//        mybatisPlus.setMapperLocations(this.properties.resolveMapperLocations());
//        // 设置mapper.xml文件的路径
////        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
////        Resource[] resource = resolver.getResources("classpath:mapper/*.xml");
////        mybatisPlus.setMapperLocations(resource);
//        return mybatisPlus;
//    }
}

