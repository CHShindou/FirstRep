package cn.xdl.ovls.study.user.bean;

import java.io.Serializable;
import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;

import cn.xdl.ovls.study.course.bean.Course;

public class CollectCourse implements Serializable{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column collect_course.Id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column collect_course.user_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column collect_course.course_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    private Integer courseId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column collect_course.collect_time
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    private Date collectTime;
    
    /**
     * course_id对应的course信息
     * */
    private Course course;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column collect_course.Id
     *
     * @return the value of collect_course.Id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column collect_course.Id
     *
     * @param id the value for collect_course.Id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column collect_course.user_id
     *
     * @return the value of collect_course.user_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column collect_course.user_id
     *
     * @param userId the value for collect_course.user_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column collect_course.course_id
     *
     * @return the value of collect_course.course_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column collect_course.course_id
     *
     * @param courseId the value for collect_course.course_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column collect_course.collect_time
     *
     * @return the value of collect_course.collect_time
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getCollectTime() {
        return collectTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column collect_course.collect_time
     *
     * @param collectTime the value for collect_course.collect_time
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }
}