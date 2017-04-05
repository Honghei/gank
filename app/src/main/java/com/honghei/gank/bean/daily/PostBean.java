package com.honghei.gank.bean.daily;

/**
 * @author Honghei
 * @time 2017/4/4  8:53
 * @desc ${TODD}
 */
public class PostBean {
    /**
     * id : 39458
     * genre : 1
     * title : 英国确定脱欧之后，上百张明信片开始了和欧洲的“对话”
     * description : 英国设计师：欧盟，请依然和我们做朋友！
     * publish_time : 1491261269
     * image : http://img.qdaily.com/article/article_show/20170403154526jgb5NcGDi2XH86hR.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1
     * start_time : 0
     * comment_count : 1
     * praise_count : 13
     * super_tag :
     * page_style : 0
     * post_id : 41054
     * appview : http://app3.qdaily.com/app3/articles/39458.html
     * film_length :
     * datatype : article
     * category : {"id":17,"title":"设计","normal":"http://img.qdaily.com/category/icon_black/20160606004538bpyX8Nm7dL4ns5WQ.png?imageMogr2/auto-orient/thumbnail/!128x128r/gravity/Center/crop/128x128/quality/85/ignore-error/1","normal_hl":"http://img.qdaily.com/category/icon_yellow_app/201606060045382gYtJkaTwmRrLq9B.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1","image_lab":"http://img.qdaily.com/category/icon_yellow_app/201606060045382gYtJkaTwmRrLq9B.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1","image_experiment":""}
     */

    private int id;
    private int genre;
    private String title;
    private String description;
    private int publish_time;
    private String image;
    private int start_time;
    private int comment_count;
    private int praise_count;
    private String super_tag;
    private int page_style;
    private int post_id;
    private String appview;
    private String film_length;
    private String datatype;
    private CategoryBean category;
    private ColumnsBean column;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(int publish_time) {
        this.publish_time = publish_time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getPraise_count() {
        return praise_count;
    }

    public void setPraise_count(int praise_count) {
        this.praise_count = praise_count;
    }

    public String getSuper_tag() {
        return super_tag;
    }

    public void setSuper_tag(String super_tag) {
        this.super_tag = super_tag;
    }

    public int getPage_style() {
        return page_style;
    }

    public void setPage_style(int page_style) {
        this.page_style = page_style;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getAppview() {
        return appview;
    }

    public void setAppview(String appview) {
        this.appview = appview;
    }

    public String getFilm_length() {
        return film_length;
    }

    public void setFilm_length(String film_length) {
        this.film_length = film_length;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public CategoryBean getCategory() {
        return category;
    }

    public void setCategory(CategoryBean category) {
        this.category = category;
    }

    public ColumnsBean getColumn(){return column; }

    public void setColumn(ColumnsBean column) {this.column = column; }

    @Override
    public String toString() {
        return "PostBean{" +
                "id=" + id +
                ", genre=" + genre +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", publish_time=" + publish_time +
                ", image='" + image + '\'' +
                ", start_time=" + start_time +
                ", comment_count=" + comment_count +
                ", praise_count=" + praise_count +
                ", super_tag='" + super_tag + '\'' +
                ", page_style=" + page_style +
                ", post_id=" + post_id +
                ", appview='" + appview + '\'' +
                ", film_length='" + film_length + '\'' +
                ", datatype='" + datatype + '\'' +
                ", category=" + category +
                ", column=" + column +
                '}';
    }
}
