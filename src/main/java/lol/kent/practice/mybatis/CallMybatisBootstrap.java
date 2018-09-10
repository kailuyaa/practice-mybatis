package lol.kent.practice.mybatis;

import lol.kent.practice.mybatis.config.DataSource;
import lol.kent.practice.mybatis.domain.Blog;
import lol.kent.practice.mybatis.mapper.BlogMapper;
import org.apache.ibatis.session.SqlSession;

/**
 * Description:
 *
 * @auth kentc
 * @date 2018-09-10
 */
public class CallMybatisBootstrap {

    public static void main(String[] args) {
        SqlSession session = DataSource.sqlSession();
        BlogMapper blogMapper = session.getMapper(BlogMapper.class);
        Blog blog = blogMapper.selectBlog(1L);

        System.out.println(blog.getName());
    }

}
