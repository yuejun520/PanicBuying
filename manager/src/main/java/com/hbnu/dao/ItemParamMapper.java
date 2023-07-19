package com.hbnu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hbnu.pojo.ItemParam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : [LuanHao]
 * @createTime : [7/6/2023 下午 3:45]
 */

@Repository
public interface ItemParamMapper extends BaseMapper<ItemParam> {

    @Select("select * from tb_item_param order by updated desc limit #{start}, #{rows}")
    List<ItemParam> findItemParamByPage(@Param("start") Integer start, @Param("rows") Integer rows);
}
