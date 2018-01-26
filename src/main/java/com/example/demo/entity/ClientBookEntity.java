package com.example.demo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 书籍
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-01-26 11:22:17
 */
public class ClientBookEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //序号
    private Long id;
    //书名
    private String name;
    //作者
    private String author;
    //作品分类
    private Integer typeworks;
    //作品类型
    private Integer typework;
    //作品字数
    private Long workscount;
    //收藏数
    private Integer store;
    //是否完结1true
    private Integer state;
    //创建时间
    private Date createdate;
    //修改时间
    private Date updatedate;

    /**
     * 设置：序号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：序号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：书名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：书名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取：作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置：作品分类
     */
    public void setTypeworks(Integer typeworks) {
        this.typeworks = typeworks;
    }

    /**
     * 获取：作品分类
     */
    public Integer getTypeworks() {
        return typeworks;
    }

    /**
     * 设置：作品类型
     */
    public void setTypework(Integer typework) {
        this.typework = typework;
    }

    /**
     * 获取：作品类型
     */
    public Integer getTypework() {
        return typework;
    }

    /**
     * 设置：作品字数
     */
    public void setWorkscount(Long workscount) {
        this.workscount = workscount;
    }

    /**
     * 获取：作品字数
     */
    public Long getWorkscount() {
        return workscount;
    }

    /**
     * 设置：收藏数
     */
    public void setStore(Integer store) {
        this.store = store;
    }

    /**
     * 获取：收藏数
     */
    public Integer getStore() {
        return store;
    }

    /**
     * 设置：是否完结1true
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取：是否完结1true
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置：创建时间
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取：创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置：修改时间
     */
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 获取：修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getUpdatedate() {
        return updatedate;
    }
}
