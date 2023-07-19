package com.hbnu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hbnu.pojo.Item;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : [LuanHao]
 * @createTime : [5/6/2023 下午 5:25]
 */

@Repository
public interface ItemMapper extends BaseMapper<Item> {

    @Select("select * from tb_item order by updated desc limit #{start}, #{rows}")
    List<Item> findItemByPage(@Param("start") Integer start, @Param("rows") Integer rows);
}
