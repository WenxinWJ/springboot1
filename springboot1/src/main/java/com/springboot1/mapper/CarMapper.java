package com.springboot1.mapper;

import com.springboot1.domain.Car;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 映射器接口
 */
@Repository
public interface CarMapper {

    // 增
    @Insert("insert into car(name,price,create_date) values(#{name},#{price},#{createDate})")
    Integer addCar(Car car);

    // 删
    @Delete("delete from car where id = #{id}")
    Integer remove(Integer id);

    // 改
    @Update("update car set name =#{name},price=#{price},create_date=#{createDate} where id =#{id}")
    Integer modify(Car car);

    // 查询所有
    @Select("select * from car")
    @Results({
            @Result(property = "createDate", column = "create_date")
    })
    List<Car> find();

    // id 查询
    @Select("select id,name,price,create_date createDate from car where id =#{id}")
    Car findId(Integer id);

    // 模糊查询
    List<Car> findCar(@Param("name") String name,
                      @Param("beginDate") Date beginDate,
                      @Param("endDate") Date endDate);
}
