package cn.xdl.ovls.study.user.bean;

import java.io.Serializable;
import java.util.Date;

import cn.xdl.ovls.study.course.bean.Course;
import cn.xdl.ovls.study.video.bean.Video;

public class BrowsingHistory implements Serializable{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column browsing_history.id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    private Integer id;

    public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column browsing_history.use_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    private Integer useId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column browsing_history.course_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    private Integer courseId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column browsing_history.browse_time
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    private Date browseTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column browsing_history.video_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    private Integer videoId;
    
    /**
     * 浏览记录中学科id对应的学科详细信息
     * */
    private Course course;
    
    /**
     * 该浏览记录中视频id对应的视频详情
     * */
    private Video video;
    
    /**
     * 对应的视频中包含的笔记的数量
     * */
    private Integer noteCount;
    
    /**
     * 对应的视频中包含的问题的数量
     * */
    private Integer issueCount;
    
    public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Integer getNoteCount() {
		return noteCount;
	}

	public void setNoteCount(Integer noteCount) {
		this.noteCount = noteCount;
	}

	public Integer getIssueCount() {
		return issueCount;
	}

	public void setIssueCount(Integer issueCount) {
		this.issueCount = issueCount;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column browsing_history.id
     *
     * @return the value of browsing_history.id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column browsing_history.id
     *
     * @param id the value for browsing_history.id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column browsing_history.use_id
     *
     * @return the value of browsing_history.use_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public Integer getUseId() {
        return useId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column browsing_history.use_id
     *
     * @param useId the value for browsing_history.use_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public void setUseId(Integer useId) {
        this.useId = useId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column browsing_history.course_id
     *
     * @return the value of browsing_history.course_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column browsing_history.course_id
     *
     * @param courseId the value for browsing_history.course_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column browsing_history.browse_time
     *
     * @return the value of browsing_history.browse_time
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public Date getBrowseTime() {
        return browseTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column browsing_history.browse_time
     *
     * @param browseTime the value for browsing_history.browse_time
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public void setBrowseTime(Date browseTime) {
        this.browseTime = browseTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column browsing_history.video_id
     *
     * @return the value of browsing_history.video_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public Integer getVideoId() {
        return videoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column browsing_history.video_id
     *
     * @param videoId the value for browsing_history.video_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }
}