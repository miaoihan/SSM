package com.zh.map;

import com.zh.models.User;
import org.apache.ibatis.annotations.Select;

/**
 * time: 16-5-12.
 * author: han
 */
public interface UserMapper {
    /**  通过映射器类注解来执行解析sql   */
    @Select("select * from user where id = #{id}")
    User selectUser(int id);

}
