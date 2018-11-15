package cn.xdl.ovls.study.video.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import cn.xdl.ovls.study.video.bean.Answer;

public interface AnswerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table answer
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Delete({
        "delete from answer",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table answer
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Insert({
        "insert into answer (context, ",
        "publish_time, issue_id, ",
        "user_id)",
        "values (#{context,jdbcType=VARCHAR}, ",
        "#{publishTime,jdbcType=TIMESTAMP}, #{issueId,jdbcType=INTEGER}, ",
        "#{userId,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
    int insert(Answer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table answer
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @InsertProvider(type=AnswerSqlProvider.class, method="insertSelective")
    int insertSelective(Answer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table answer
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Select({
        "select",
        "id, context, publish_time, issue_id, user_id",
        "from answer",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="context", property="context", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="issue_id", property="issueId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER)
    })
    Answer selectByPrimaryKey(Integer id);
    
    
    /**
     * 通过问题Id查询该问题的所有回答
     * */
    @Select({
        "select",
        "id, context, publish_time, issue_id, user_id",
        "from answer",
        "where issue_id = #{issue_id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="context", property="context", jdbcType=JdbcType.VARCHAR),
        @Result(column="publish_time", property="publishTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="issue_id", property="issueId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id",property="user",one=@One(fetchType=FetchType.EAGER,
        		select="cn.xdl.ovls.study.user.dao.UserMapper.selectByPrimaryKey"))
    })
    List<Answer> selectByIssue(Integer issue_id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table answer
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @UpdateProvider(type=AnswerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Answer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table answer
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Update({
        "update answer",
        "set context = #{context,jdbcType=VARCHAR},",
          "publish_time = #{publishTime,jdbcType=TIMESTAMP},",
          "issue_id = #{issueId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Answer record);
}