package lol.kent.practice.mybatis.conf;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lol.kent.practice.mybatis.mapper.BlogMapper;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

/**
 * Description:
 *
 * @auth kentc
 * @date 2018-09-14
 */
public class SqlSessionManager {

    private static DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://rm-wz9515p648o5t6is9o.mysql.rds.aliyuncs.com:3306/test");
        config.setUsername("devops");
        config.setPassword("devOps!@#");
        return new HikariDataSource(config);
    }


    private static SqlSessionFactory sqlSessionFactory() {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource());
        Configuration configuration = new Configuration(environment);
        //TODO: 修改为自动扫描
        configuration.addMapper(BlogMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
    }

    public static SqlSession sqlSession() {
        return sqlSessionFactory().openSession();
    }

}
