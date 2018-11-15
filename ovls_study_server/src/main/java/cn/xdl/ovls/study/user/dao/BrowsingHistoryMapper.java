package cn.xdl.ovls.study.user.dao;


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

import cn.xdl.ovls.study.user.bean.BrowsingHistory;

public interface BrowsingHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table browsing_history
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Delete({
        "delete from browsing_history",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table browsing_history
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Insert({
        "insert into browsing_history (id, use_id, ",
        "course_id, browse_time, ",
        "video_id)",
        "values (#{id,jdbcType=INTEGER}, #{useId,jdbcType=INTEGER}, ",
        "#{courseId,jdbcType=INTEGER}, #{browseTime,jdbcType=TIMESTAMP}, ",
        "#{videoId,jdbcType=INTEGER})"
    })
    int insert(BrowsingHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table browsing_history
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @InsertProvider(type=BrowsingHistorySqlProvider.class, method="insertSelective")
    int insertSelective(BrowsingHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table browsing_history
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Select({
        "select",
        "id, use_id, course_id, browse_time, video_id",
        "from browsing_history",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="use_id", property="useId", jdbcType=JdbcType.INTEGER),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER),
        @Result(column="browse_time", property="browseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="video_id", property="videoId", jdbcType=JdbcType.INTEGER)
    })
    BrowsingHistory selectByPrimaryKey(Integer id);
    
    
    /**
     * 通过userId查询该用户的浏览记录,并按照时间降序排序
     * */
    @Select({
        "select",
        "id, use_id, course_id, browse_time, video_id",
        "from browsing_history",
        "where use_id = #{use_id,jdbcType=INTEGER}",
        "order by browse_time desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="use_id", property="useId", jdbcType=JdbcType.INTEGER),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER),
        @Result(column="browse_time", property="browseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="video_id", property="videoId", jdbcType=JdbcType.INTEGER)
    })
    List<BrowsingHistory> selectByUser(Integer use_id);
    /**
     * 通过User_id和Course_id查询记录
     * */
    @Select({
        "select",
        "id, use_id, course_id, browse_time, video_id",
        "from browsing_history",
        "where use_id = #{0} and video_id = #{1}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="use_id", property="useId", jdbcType=JdbcType.INTEGER),
        @Result(column="course_id", property="courseId", jdbcType=JdbcType.INTEGER),
        @Result(column="browse_time", property="browseTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="video_id", property="videoId", jdbcType=JdbcType.INTEGER)
    })
    BrowsingHistory selectByUserAndCourse(Integer userId,Integer videoId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table browsing_history
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @UpdateProvider(type=BrowsingHistorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BrowsingHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table browsing_history
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Update({
        "update browsing_history",
        "set use_id = #{useId,jdbcType=INTEGER},",
          "course_id = #{courseId,jdbcType=INTEGER},",
          "browse_time = #{browseTime,jdbcType=TIMESTAMP},",
          "video_id = #{videoId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(BrowsingHistory record);
    
    
    /**
     * 通过user_id 和course_id 更新浏览记录
     * 写好了，发现这个没什么用，就留在这里吧
     * */
    @Update({
        "update browsing_history",
        "set use_id = #{useId,jdbcType=INTEGER},",
          "course_id = #{courseId,jdbcType=INTEGER},",
          "browse_time = #{browseTime,jdbcType=TIMESTAMP},",
          "video_id = #{videoId,jdbcType=INTEGER}",
        "where use_id = #{useId,jdbcType=INTEGER}",
        "and course_id = #{courseId,jdbcType=INTEGER}"
    })
    int updateByUserAndCourse(BrowsingHistory record);
}