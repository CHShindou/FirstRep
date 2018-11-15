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

import cn.xdl.ovls.study.course.bean.Course;

public interface CourseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Delete({
        "delete from course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Insert({
        "insert into course (id, name, ",
        "intro, learn_count, ",
        "difficulty, score, ",
        "image, publish_time, ",
        "price, subject_id, ",
        "direction_id, learn_time)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{intro,jdbcType=VARCHAR}, #{learnCount,jdbcType=INTEGER}, ",
        "#{difficulty,jdbcType=VARCHAR}, #{score,jdbcType=INTEGER}, ",
        "#{image,jdbcType=VARCHAR}, #{publishTime,jdbcType=TIMESTAMP}, ",
        "#{price,jdbcType=INTEGER}, #{subjectId,jdbcType=INTEGER}, ",
        "#{directionId,jdbcType=INTEGER}, #{learnTime,jdbcType=INTEGER})"
    })
    int insert(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @InsertProvider(type=CourseSqlProvider.class, method="insertSelective")
    int insertSelective(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Select({
        "select",
        "id, name, intro, learn_count, difficulty, score, image, publish_time, price, ",
        "subject_id, direction_id, learn_time",
        "from course",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="learn_count", property="learnCount", jdbcType=JdbcType.INTEGER),
        @Result(column="difficulty", property="difficulty", jdbcType=JdbcType.VARCHAR),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="price", property="price", jdbcType=JdbcType.INTEGER),
        @Result(column="subject_id", property="subjectId", jdbcType=JdbcType.INTEGER),
        @Result(column="direction_id", property="directionId", jdbcType=JdbcType.INTEGER),
        @Result(column="learn_time", property="learnTime", jdbcType=JdbcType.INTEGER)
    })
    Course selectByPrimaryKey(Integer id);
    
    
    /**
     * 查询所有价格为0的课程，并按照评分降序排序
     * */
    @Select({
        "select",
        "id, name, intro, learn_count, difficulty, score, image, publish_time, price, ",
        "subject_id, direction_id, learn_time",
        "from course",
        "where price = 0",
        "order by score desc,name"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="learn_count", property="learnCount", jdbcType=JdbcType.INTEGER),
        @Result(column="difficulty", property="difficulty", jdbcType=JdbcType.VARCHAR),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="price", property="price", jdbcType=JdbcType.INTEGER),
        @Result(column="subject_id", property="subjectId", jdbcType=JdbcType.INTEGER),
        @Result(column="direction_id", property="directionId", jdbcType=JdbcType.INTEGER),
        @Result(column="learn_time", property="learnTime", jdbcType=JdbcType.INTEGER)
    })
    List<Course> selectByPrice();
    
       
    /**
     * 根据关键字搜索课程,通过评分降序排序
     * */
    @Select({
        "select",
        "id, name, intro, learn_count, difficulty, score, image, publish_time, price, ",
        "subject_id, direction_id, learn_time",
        "from course",
        "where name like #{searchValue,jdbcType=VARCHAR}",
        "or intro like #{searchValue,jdbcType=VARCHAR}",
        "order by score desc,name"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="learn_count", property="learnCount", jdbcType=JdbcType.INTEGER),
        @Result(column="difficulty", property="difficulty", jdbcType=JdbcType.VARCHAR),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="price", property="price", jdbcType=JdbcType.INTEGER),
        @Result(column="subject_id", property="subjectId", jdbcType=JdbcType.INTEGER),
        @Result(column="direction_id", property="directionId", jdbcType=JdbcType.INTEGER),
        @Result(column="learn_time", property="learnTime", jdbcType=JdbcType.INTEGER)
    })
    List<Course> searchByNameOrIntro(String searchValue);
    
    
    /**
     * 根据direction_id查询所有的course数据，并按照评分score降序排序
     * 
     * */
    @Select({
        "select",
        "id, name, intro, learn_count, difficulty, score, image, publish_time, price, ",
        "subject_id, direction_id, learn_time",
        "from course",
        "where direction_id = #{direction_id,jdbcType=INTEGER}",
        "order by score desc,name"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="learn_count", property="learnCount", jdbcType=JdbcType.INTEGER),
        @Result(column="difficulty", property="difficulty", jdbcType=JdbcType.VARCHAR),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="price", property="price", jdbcType=JdbcType.INTEGER),
        @Result(column="subject_id", property="subjectId", jdbcType=JdbcType.INTEGER),
        @Result(column="direction_id", property="directionId", jdbcType=JdbcType.INTEGER),
        @Result(column="learn_time", property="learnTime", jdbcType=JdbcType.INTEGER)
    })
    List<Course> selectByDirectionId(Integer direction_id);
    
    
    /**
     * 根据subject_id查找所有的course数据
     * */
    @Select({
        "select",
        "id, name, intro, learn_count, difficulty, score, image, publish_time, price, ",
        "subject_id, direction_id, learn_time",
        "from course",
        "where subject_id = #{subject_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="learn_count", property="learnCount", jdbcType=JdbcType.INTEGER),
        @Result(column="difficulty", property="difficulty", jdbcType=JdbcType.VARCHAR),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="price", property="price", jdbcType=JdbcType.INTEGER),
        @Result(column="subject_id", property="subjectId", jdbcType=JdbcType.INTEGER),
        @Result(column="direction_id", property="directionId", jdbcType=JdbcType.INTEGER),
        @Result(column="learn_time", property="learnTime", jdbcType=JdbcType.INTEGER)
    })
    List<Course> selectBySubjectId(Integer subject_id);
    /**
     * 根据评分降序查找所有的课程
     * */
    @Select({
        "select",
        "id, name, intro, learn_count, difficulty, score, image, publish_time, price, ",
        "subject_id, direction_id, learn_time",
        "from course",
        "order by score desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="learn_count", property="learnCount", jdbcType=JdbcType.INTEGER),
        @Result(column="difficulty", property="difficulty", jdbcType=JdbcType.VARCHAR),
        @Result(column="score", property="score", jdbcType=JdbcType.INTEGER),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="price", property="price", jdbcType=JdbcType.INTEGER),
        @Result(column="subject_id", property="subjectId", jdbcType=JdbcType.INTEGER),
        @Result(column="direction_id", property="directionId", jdbcType=JdbcType.INTEGER),
        @Result(column="learn_time", property="learnTime", jdbcType=JdbcType.INTEGER)
    })
    List<Course> selectOrderByScore();
    
   
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @UpdateProvider(type=CourseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Course record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Update({
        "update course",
        "set name = #{name,jdbcType=VARCHAR},",
          "intro = #{intro,jdbcType=VARCHAR},",
          "learn_count = #{learnCount,jdbcType=INTEGER},",
          "difficulty = #{difficulty,jdbcType=VARCHAR},",
          "score = #{score,jdbcType=INTEGER},",
          "image = #{image,jdbcType=VARCHAR},",
          "publish_time = #{publishTime,jdbcType=TIMESTAMP},",
          "price = #{price,jdbcType=INTEGER},",
          "subject_id = #{subjectId,jdbcType=INTEGER},",
          "direction_id = #{directionId,jdbcType=INTEGER},",
          "learn_time = #{learnTime,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Course record);
}