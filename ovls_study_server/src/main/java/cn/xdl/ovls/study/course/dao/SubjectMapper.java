package cn.xdl.ovls.study.course.dao;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

import cn.xdl.ovls.study.course.bean.Subject;

public interface SubjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table subject
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Delete({
        "delete from subject",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table subject
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Insert({
        "insert into subject (id, name, ",
        "direction_id)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{directionId,jdbcType=INTEGER})"
    })
    int insert(Subject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table subject
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @InsertProvider(type=SubjectSqlProvider.class, method="insertSelective")
    int insertSelective(Subject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table subject
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Select({
        "select",
        "id, name, direction_id",
        "from subject",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="direction_id", property="directionId", jdbcType=JdbcType.INTEGER)
    })
    Subject selectByPrimaryKey(Integer id);
    
    /**
     * 通过direction_id 查询subject数据
     * 
     * */
    @Select({
        "select",
        "id, name, direction_id",
        "from subject",
        "where direction_id = #{direction_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="direction_id", property="directionId", jdbcType=JdbcType.INTEGER)
    })
    List<Subject> selectByDirectionId(Integer direction_id);

    /**
     * 查询所有的Subject信息
     * */
    @Select({
        "select",
        "id, name, direction_id",
        "from subject"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="direction_id", property="directionId", jdbcType=JdbcType.INTEGER)
    })
    List<Subject> selectAllSubject();
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table subject
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @UpdateProvider(type=SubjectSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Subject record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table subject
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Update({
        "update subject",
        "set name = #{name,jdbcType=VARCHAR},",
          "direction_id = #{directionId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Subject record);
}