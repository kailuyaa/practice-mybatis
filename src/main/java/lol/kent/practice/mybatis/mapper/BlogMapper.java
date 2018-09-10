package lol.kent.practice.mybatis.mapper;

import lol.kent.practice.mybatis.domain.Blog;

/**
 * Description:
 *
 * @auth kentc
 * @date 2018-09-10
 */
public interface BlogMapper {

    Blog selectBlog(Long id);
}
