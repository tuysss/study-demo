package com.tuysss.mapper;

import com.tuysss.pojo.Blog;

public interface BlogMapper {
    int insert(Blog row);

    int insertSelective(Blog row);
}