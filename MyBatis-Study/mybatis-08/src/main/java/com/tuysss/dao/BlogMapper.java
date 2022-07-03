package com.tuysss.dao;

import com.tuysss.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //插入数据
    int addBlog(Blog blog);

    //查询
    List<Blog> queryBlogIF(Map map);

    //查询，只允许一个限定条件
    List<Blog> queryBlogChoose(Map map);

    //更新博客
    int updateBlog(Map map);

    //查询第1~3号记录的id
    List<Blog> queryBlogForeach(Map map);

}
