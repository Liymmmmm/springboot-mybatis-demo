package com.lym.springbootmybatis.mapper;
import	java.net.URL;


import org.apache.ibatis.annotations.*;
import com.lym.springbootmybatis.pojo.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("select * from category_ ")
    List<Category> findAll();

    @Insert("insert into category_ (name) values (#{name})")
    public int save(Category category);

    @Delete("delete from category_ where id = #{id}")
    public int delete(int id);

    @Update("update category_ set name = #{name} where id = #{id}")
    public int update(Category category);

    @Select("select * from category_ where id = #{id}")
    public Category get(int id);
}


