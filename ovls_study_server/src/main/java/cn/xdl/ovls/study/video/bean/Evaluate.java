package cn.xdl.ovls.study.video.bean;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.xdl.ovls.study.user.bean.User;

/**
 * 评价信息的实体类
 * */
public class Evaluate implements Serializable{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.use_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    private Integer useId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.context
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    private String context;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.publish_time
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    private Date publishTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.video_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    private Integer videoId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column evaluate.like_count
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    private Integer likeCount;
    
    /**
     * user_id 对应的name
     * */
    private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.id
     *
     * @return the value of evaluate.id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.id
     *
     * @param id the value for evaluate.id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.use_id
     *
     * @return the value of evaluate.use_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public Integer getUseId() {
        return useId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.use_id
     *
     * @param useId the value for evaluate.use_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public void setUseId(Integer useId) {
        this.useId = useId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.context
     *
     * @return the value of evaluate.context
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public String getContext() {
        return context;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.context
     *
     * @param context the value for evaluate.context
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.publish_time
     *
     * @return the value of evaluate.publish_time
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    public Date getPublishTime() {
        return publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.publish_time
     *
     * @param publishTime the value for evaluate.publish_time
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.video_id
     *
     * @return the value of evaluate.video_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public Integer getVideoId() {
        return videoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.video_id
     *
     * @param videoId the value for evaluate.video_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column evaluate.like_count
     *
     * @return the value of evaluate.like_count
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column evaluate.like_count
     *
     * @param likeCount the value for evaluate.like_count
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }
}