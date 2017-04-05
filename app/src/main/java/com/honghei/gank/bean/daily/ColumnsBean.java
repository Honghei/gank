package com.honghei.gank.bean.daily;

/**
 * @author Honghei
 * @time 2017/4/4  8:58
 * @desc ${TODD}
 */
public class ColumnsBean {
    /**
     * id : 38
     * name : 这个设计了不起
     * description : 总能找到好看的东西
     * subscribe_status : true
     * icon : http://img.qdaily.com/special_column/icon/20160703183440nKed1jf6mG9VcJZL.png?imageMogr2/auto-orient/thumbnail/!128x128r/gravity/Center/crop/128x128/quality/85/format/jpg/ignore-error/1
     * image : http://img.qdaily.com/special_column/column/20160703183440in6zCrSyDRGvwWPp.jpg?imageMogr2/auto-orient/thumbnail/!320x320r/gravity/Center/crop/320x320/quality/85/format/jpg/ignore-error/1
     * image_large : http://img.qdaily.com/special_column/column/20160703183440in6zCrSyDRGvwWPp.jpg?imageMogr2/auto-orient/thumbnail/!750x604r/gravity/Center/crop/750x604/quality/85/format/jpg/ignore-error/1
     * content_provider : 好奇心日报
     * show_type : 1
     * genre : 1
     * subscriber_num : 121512
     * post_count : 510
     * sort_time : 2017-04-04 07:14:53 +0800
     * column_tag : special_columns_38
     * share : {"url":"http://m.qdaily.com/mobile/special_columns/38.html","title":"这个设计了不起_好奇心日报","text":"总能找到好看的东西","image":"http://img.qdaily.com/special_column/column/20160703183440in6zCrSyDRGvwWPp.jpg?imageMogr2/auto-orient/thumbnail/!320x320r/gravity/Center/crop/320x320/quality/85/format/jpg/ignore-error/1"}
     */

    private int id;
    private String name;
    private String description;
    private boolean subscribe_status;
    private String icon;
    private String image;
    private String image_large;
    private String content_provider;
    private int show_type;
    private int genre;
    private int subscriber_num;
    private int post_count;
    private String sort_time;
    private String column_tag;
    private ShareBean share;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSubscribe_status() {
        return subscribe_status;
    }

    public void setSubscribe_status(boolean subscribe_status) {
        this.subscribe_status = subscribe_status;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage_large() {
        return image_large;
    }

    public void setImage_large(String image_large) {
        this.image_large = image_large;
    }

    public String getContent_provider() {
        return content_provider;
    }

    public void setContent_provider(String content_provider) {
        this.content_provider = content_provider;
    }

    public int getShow_type() {
        return show_type;
    }

    public void setShow_type(int show_type) {
        this.show_type = show_type;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public int getSubscriber_num() {
        return subscriber_num;
    }

    public void setSubscriber_num(int subscriber_num) {
        this.subscriber_num = subscriber_num;
    }

    public int getPost_count() {
        return post_count;
    }

    public void setPost_count(int post_count) {
        this.post_count = post_count;
    }

    public String getSort_time() {
        return sort_time;
    }

    public void setSort_time(String sort_time) {
        this.sort_time = sort_time;
    }

    public String getColumn_tag() {
        return column_tag;
    }

    public void setColumn_tag(String column_tag) {
        this.column_tag = column_tag;
    }

    public ShareBean getShare() {
        return share;
    }

    public void setShare(ShareBean share) {
        this.share = share;
    }


    @Override
    public String toString() {
        return "ColumnsBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", subscribe_status=" + subscribe_status +
                ", icon='" + icon + '\'' +
                ", image='" + image + '\'' +
                ", image_large='" + image_large + '\'' +
                ", content_provider='" + content_provider + '\'' +
                ", show_type=" + show_type +
                ", genre=" + genre +
                ", subscriber_num=" + subscriber_num +
                ", post_count=" + post_count +
                ", sort_time='" + sort_time + '\'' +
                ", column_tag='" + column_tag + '\'' +
                ", share=" + share +
                '}';
    }
}
