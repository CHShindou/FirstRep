package cn.xdl.ovls.study.course.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.xdl.ovls.study.course.bean.Course;



public class CourseSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public String insertSelective(Course record) {
        BEGIN();
        INSERT_INTO("course");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIntro() != null) {
            VALUES("intro", "#{intro,jdbcType=VARCHAR}");
        }
        
        if (record.getLearnCount() != null) {
            VALUES("learn_count", "#{learnCount,jdbcType=INTEGER}");
        }
        
        if (record.getDifficulty() != null) {
            VALUES("difficulty", "#{difficulty,jdbcType=VARCHAR}");
        }
        
        if (record.getScore() != null) {
            VALUES("score", "#{score,jdbcType=INTEGER}");
        }
        
        if (record.getImage() != null) {
            VALUES("image", "#{image,jdbcType=VARCHAR}");
        }
        
        if (record.getPublishTime() != null) {
            VALUES("publish_time", "#{publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPrice() != null) {
            VALUES("price", "#{price,jdbcType=INTEGER}");
        }
        
        if (record.getSubjectId() != null) {
            VALUES("subject_id", "#{subjectId,jdbcType=INTEGER}");
        }
        
        if (record.getDirectionId() != null) {
            VALUES("direction_id", "#{directionId,jdbcType=INTEGER}");
        }
        
        if (record.getLearnTime() != null) {
            VALUES("learn_time", "#{learnTime,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table course
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public String updateByPrimaryKeySelective(Course record) {
        BEGIN();
        UPDATE("course");
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getIntro() != null) {
            SET("intro = #{intro,jdbcType=VARCHAR}");
        }
        
        if (record.getLearnCount() != null) {
            SET("learn_count = #{learnCount,jdbcType=INTEGER}");
        }
        
        if (record.getDifficulty() != null) {
            SET("difficulty = #{difficulty,jdbcType=VARCHAR}");
        }
        
        if (record.getScore() != null) {
            SET("score = #{score,jdbcType=INTEGER}");
        }
        
        if (record.getImage() != null) {
            SET("image = #{image,jdbcType=VARCHAR}");
        }
        
        if (record.getPublishTime() != null) {
            SET("publish_time = #{publishTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPrice() != null) {
            SET("price = #{price,jdbcType=INTEGER}");
        }
        
        if (record.getSubjectId() != null) {
            SET("subject_id = #{subjectId,jdbcType=INTEGER}");
        }
        
        if (record.getDirectionId() != null) {
            SET("direction_id = #{directionId,jdbcType=INTEGER}");
        }
        
        if (record.getLearnTime() != null) {
            SET("learn_time = #{learnTime,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}