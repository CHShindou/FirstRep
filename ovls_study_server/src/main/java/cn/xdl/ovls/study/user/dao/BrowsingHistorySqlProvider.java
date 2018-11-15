package cn.xdl.ovls.study.user.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.xdl.ovls.study.user.bean.BrowsingHistory;


public class BrowsingHistorySqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table browsing_history
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public String insertSelective(BrowsingHistory record) {
        BEGIN();
        INSERT_INTO("browsing_history");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUseId() != null) {
            VALUES("use_id", "#{useId,jdbcType=INTEGER}");
        }
        
        if (record.getCourseId() != null) {
            VALUES("course_id", "#{courseId,jdbcType=INTEGER}");
        }
        
        if (record.getBrowseTime() != null) {
            VALUES("browse_time", "#{browseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVideoId() != null) {
            VALUES("video_id", "#{videoId,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table browsing_history
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public String updateByPrimaryKeySelective(BrowsingHistory record) {
        BEGIN();
        UPDATE("browsing_history");
        
        if (record.getUseId() != null) {
            SET("use_id = #{useId,jdbcType=INTEGER}");
        }
        
        if (record.getCourseId() != null) {
            SET("course_id = #{courseId,jdbcType=INTEGER}");
        }
        
        if (record.getBrowseTime() != null) {
            SET("browse_time = #{browseTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getVideoId() != null) {
            SET("video_id = #{videoId,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}