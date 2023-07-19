package com.hbnu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hbnu.pojo.Content;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : [LuanHao]
 * @createTime : [9/6/2023 上午 11:46]
 */

@Repository
public interface ContentMapper extends BaseMapper<Content> {

    @Select("select * from tb_content where category_id = #{categoryId} order by updated desc limit #{start}, #{rows}")
    List<Content> findContentByPage(Long categoryId, int start, Integer rows);
}
