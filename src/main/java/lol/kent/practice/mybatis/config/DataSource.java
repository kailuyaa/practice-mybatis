package lol.kent.practice.mybatis.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Description:
 *
 * @auth kentc
 * @date 2018-09-10
 */
public class DataSource {


    public static SqlSessionFactory sqlSessionFactoryXML() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    public static SqlSession sqlSession() {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactoryXML().openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
