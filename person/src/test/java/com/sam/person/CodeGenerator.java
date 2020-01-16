package com.sam.person;

import org.springframework.boot.test.context.SpringBootTest;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;

@SpringBootTest
public class CodeGenerator {

    @Test
    public void generateCode() {
        String packageName = "com.sam.person";
        boolean serviceNameStartWithI = true;
        generateByTables(serviceNameStartWithI, packageName);
    }

    private void generateByTables(boolean serviceNameStartWithI, String packageName) {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8&useLegacyDatetimeCode=false&serverTimezone=UTC";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL).setUrl(dbUrl).setUsername("root").setPassword("123456").setDriverName("com.mysql.cj.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true).setEntityLombokModel(false)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude("user");
        config.setActiveRecord(false).setAuthor("sam")
                .setOutputDir("/home/sam/mypro/person/src/main/java")
                .setFileOverride(true)
                .setEnableCache(false);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        new AutoGenerator()
                .setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(new PackageConfig()
                        .setParent(packageName)
                        .setController("controller")
                        .setEntity("entity.Do"))
                .execute();
    }

}
