package cn.xdl.ovls.study.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import cn.xdl.ovls.study.user.bean.CollectCourse;

public interface CollectCourseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect_course
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Delete({
        "delete from collect_course",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);
    
    /**
     * 通过user和course删除收藏表中的信息
     * */
    @Delete({
        "delete from collect_course",
        "where user_id = #{0} and course_id = #{1}"
    })
    int deleteByCourseAndUser(Integer user_id,Integer  course_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect_course
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Insert({
        "insert into collect_course (Id, user_id, ",
        "course_id, collect_time)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{courseId,jdbcType=INTEGER}, #{collectTime,jdbcType=TIMESTAMP})"
    })
    int insert(CollectCourse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect_course
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @InsertProvider(type=CollectCourseSqlProvider.class, method="insertSelective")
    int insertSelective(CollectCourse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect_course
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Select({
        "select",
        "Id, user_id, course_id, collect_time",
        "from collect_course",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER),
        @Result(column="collect_time", property="collectTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CollectCourse selectByPrimaryKey(Integer id);
    
    /**
     * 通过userId查找收藏记录,并按照收藏时间降序排序
     * */
    @Select({
        "select",
        "Id, user_id, course_id, collect_time",
        "from collect_course",
        "where user_id = #{user_id,jdbcType=INTEGER}",
        "order by collect_time desc"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER),
        @Result(column="collect_time", property="collectTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="course_id", property="course", one=@One(fetchType=FetchType.EAGER,
        		select="cn.xdl.ovls.study.course.dao.CourseMapper.selectByPrimaryKey"))
    })
    List<CollectCourse> selectByUser(Integer user_id);
    /**
     * 通过userId和courseId查询课程收藏表
     * */
    @Select({
        "select",
        "Id, user_id, course_id, collect_time",
        "from collect_course",
        "where user_id = #{0} and course_id = #{1}"
    })
    @Results({
        @Result(column="Id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER),
        @Result(column="collect_time", property="collectTime", jdbcType=JdbcType.TIMESTAMP)
    })
    CollectCourse selectByUserAndCourse(Integer user_id,Integer course_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect_course
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @UpdateProvider(type=CollectCourseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CollectCourse record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect_course
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Update({
        "update collect_course",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "course_id = #{courseId,jdbcType=INTEGER},",
          "collect_time = #{collectTime,jdbcType=TIMESTAMP}",
        "where Id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(CollectCourse record);
}