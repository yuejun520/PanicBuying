package com.hbnu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hbnu.pojo.ItemCat;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author : [LuanHao]
 * @createTime : [5/6/2023 下午 5:59]
 */

@Repository
public interface ItemCatMapper extends BaseMapper<ItemCat> {
}
