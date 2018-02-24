package com.moekosu.dubbo.api.bean;

/**
 * 工具下载实体类
 * @author chenxu
 * @date 2018/02
 */
public class Tools implements Serializable{

    private Integer id;

    private String name;

    private String url;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
