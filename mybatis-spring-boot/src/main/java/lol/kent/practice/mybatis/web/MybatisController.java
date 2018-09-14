package lol.kent.practice.mybatis.web;

import lol.kent.practice.mybatis.domain.Blog;
import lol.kent.practice.mybatis.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @auth kentc
 * @date 2018-09-14
 */
@RestController
public class MybatisController {

    @Autowired
    BlogMapper blogMapper;

    @RequestMapping("/hello")
    public String hello() {
        Blog blog = blogMapper.selectBlog(1l);
        return "Hello:" + blog.getName();
    }
}
