package cn.xdl.ovls.study.course.bean;

import java.io.Serializable;

public class Subject implements Serializable{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column subject.id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column subject.name
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column subject.direction_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    private Integer directionId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subject.id
     *
     * @return the value of subject.id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subject.id
     *
     * @param id the value for subject.id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subject.name
     *
     * @return the value of subject.name
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subject.name
     *
     * @param name the value for subject.name
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column subject.direction_id
     *
     * @return the value of subject.direction_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public Integer getDirectionId() {
        return directionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column subject.direction_id
     *
     * @param directionId the value for subject.direction_id
     *
     * @mbggenerated Wed Oct 03 18:44:56 CST 2018
     */
    public void setDirectionId(Integer directionId) {
        this.directionId = directionId;
    }
}