package lol.kent.practice.mybatis.mapper;

import lol.kent.practice.mybatis.domain.Blog;
import org.apache.ibatis.annotations.Select;

/**
 * Description:
 *
 * @auth kentc
 * @date 2018-09-14
 */
public interface BlogMapper {

    @Select("select * from blog where id = #{id}")
    Blog selectBlog(long id);

}
