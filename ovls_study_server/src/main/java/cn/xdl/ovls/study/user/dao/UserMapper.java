package cn.xdl.ovls.study.user.dao;

import cn.xdl.ovls.study.user.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Insert({
        "insert into user (id, name, ",
        "password, nick_name, ",
        "position, sex, location, ",
        "signature, image, ",
        "regtime, salt)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{nickName,jdbcType=VARCHAR}, ",
        "#{position,jdbcType=VARCHAR}, #{sex,jdbcType=VARCHAR}, #{location,jdbcType=VARCHAR}, ",
        "#{signature,jdbcType=VARCHAR}, #{image,jdbcType=VARCHAR}, ",
        "#{regtime,jdbcType=TIMESTAMP}, #{salt,jdbcType=VARCHAR})"
    })
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Select({
        "select",
        "id, name, password, nick_name, position, sex, location, signature, image, regtime, ",
        "salt",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="position", property="position", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR),
        @Result(column="signature", property="signature", jdbcType=JdbcType.VARCHAR),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="regtime", property="regtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Integer id);
    
    
    /**
     * 通过id查询该用户的昵称
     * */
    @Select({
        "select",
        "nick_name",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR)
    })
    String selectNickNameByPrimaryKey(Integer id);
    
    /**
     * 根据用户名查询user表
     * */
    @Select({
        "select",
        "id, name, password, nick_name, position, sex, location, signature, image, regtime, ",
        "salt",
        "from user",
        "where name = #{name,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="position", property="position", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="location", property="location", jdbcType=JdbcType.VARCHAR),
        @Result(column="signature", property="signature", jdbcType=JdbcType.VARCHAR),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="regtime", property="regtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="salt", property="salt", jdbcType=JdbcType.VARCHAR)
    })
    User selectByName(String name);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @Update({
        "update user",
        "set name = #{name,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "nick_name = #{nickName,jdbcType=VARCHAR},",
          "position = #{position,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "location = #{location,jdbcType=VARCHAR},",
          "signature = #{signature,jdbcType=VARCHAR},",
          "image = #{image,jdbcType=VARCHAR},",
          "regtime = #{regtime,jdbcType=TIMESTAMP},",
          "salt = #{salt,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}