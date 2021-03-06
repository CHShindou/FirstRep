package cn.xdl.ovls.study.video.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.xdl.ovls.study.video.bean.Answer;


public class AnswerSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table answer
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public String insertSelective(Answer record) {
        BEGIN();
        INSERT_INTO("answer");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getContext() != null) {
            VALUES("context", "#{context,jdbcType=VARCHAR}");
        }
        
        if (record.getPublishTime() != null) {
            VALUES("publish_time", "#{publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIssueId() != null) {
            VALUES("issue_id", "#{issueId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table answer
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public String updateByPrimaryKeySelective(Answer record) {
        BEGIN();
        UPDATE("answer");
        
        if (record.getContext() != null) {
            SET("context = #{context,jdbcType=VARCHAR}");
        }
        
        if (record.getPublishTime() != null) {
            SET("publish_time = #{publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getIssueId() != null) {
            SET("issue_id = #{issueId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}