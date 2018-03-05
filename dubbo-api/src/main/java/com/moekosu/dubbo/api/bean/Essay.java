package com.moekosu.dubbo.api.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenxu
 * @date 2018/03
 */
public class Essay extends EssayGroup implements Serializable{

    private static final long serialVersionUID = 6640528660961194055L;

    // 文章id
    private String id;

    // 文章标题
    private String title;

    // 文章内容
    private String content;

    // 创建时间
    private Date createDate;

    // 文章状态
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
