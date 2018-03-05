package com.moekosu.dubbo.api.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenxu
 * @date 2018/03
 */
public class MessageBoard implements Serializable{

    private static final long serialVersionUID = 3299735860576670826L;

    private String id;

    private String author;

    private String content;

    private Date createDate;

    // 引用别人的留言(先不做)
    private MessageBoard msg1;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public MessageBoard getMsg1() {
        return msg1;
    }

    public void setMsg1(MessageBoard msg1) {
        this.msg1 = msg1;
    }
}
