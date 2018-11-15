package cn.xdl.ovls.study.course.bean;

import java.io.Serializable;
import java.util.List;

public class Direction implements Serializable{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column direction.id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column direction.name
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    private String name;
    
    /**
     * 方向包含的所有学科
     * */
    private List<Subject> subjects;
    
    /**
     * 方向包含的所有课程（这里主要用药推荐的课程）
     * */
    private List<Course> courses;
    
    public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column direction.id
     *
     * @return the value of direction.id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column direction.id
     *
     * @param id the value for direction.id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column direction.name
     *
     * @return the value of direction.name
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column direction.name
     *
     * @param name the value for direction.name
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}