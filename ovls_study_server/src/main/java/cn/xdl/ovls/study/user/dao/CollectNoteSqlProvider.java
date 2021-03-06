package cn.xdl.ovls.study.user.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import cn.xdl.ovls.study.user.bean.CollectNote;


public class CollectNoteSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect_note
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public String insertSelective(CollectNote record) {
        BEGIN();
        INSERT_INTO("collect_note");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getNoteId() != null) {
            VALUES("note_id", "#{noteId,jdbcType=INTEGER}");
        }
        
        if (record.getCollectTime() != null) {
            VALUES("collect_time", "#{collectTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table collect_note
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public String updateByPrimaryKeySelective(CollectNote record) {
        BEGIN();
        UPDATE("collect_note");
        
        if (record.getUserId() != null) {
            SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getNoteId() != null) {
            SET("note_id = #{noteId,jdbcType=INTEGER}");
        }
        
        if (record.getCollectTime() != null) {
            SET("collect_time = #{collectTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}