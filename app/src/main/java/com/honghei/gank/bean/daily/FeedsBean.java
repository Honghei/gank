package com.honghei.gank.bean.daily;

/**
 * @author Honghei
 * @time 2017/4/4  8:52
 * @desc ${TODD}
 */
public class FeedsBean {
    /**
     * image : http://img.qdaily.com/article/article_show/20170403154526jgb5NcGDi2XH86hR.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1
     * type : 1
     * post : {"id":39458,"genre":1,"title":"英国确定脱欧之后，上百张明信片开始了和欧洲的\u201c对话\u201d","description":"英国设计师：欧盟，请依然和我们做朋友！","publish_time":1491261269,"image":"http://img.qdaily.com/article/article_show/20170403154526jgb5NcGDi2XH86hR.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1","start_time":0,"comment_count":1,"praise_count":13,"super_tag":"","page_style":0,"post_id":41054,"appview":"http://app3.qdaily.com/app3/articles/39458.html","film_length":"","datatype":"article","category":{"id":17,"title":"设计","normal":"http://img.qdaily.com/category/icon_black/20160606004538bpyX8Nm7dL4ns5WQ.png?imageMogr2/auto-orient/thumbnail/!128x128r/gravity/Center/crop/128x128/quality/85/ignore-error/1","normal_hl":"http://img.qdaily.com/category/icon_yellow_app/201606060045382gYtJkaTwmRrLq9B.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1","image_lab":"http://img.qdaily.com/category/icon_yellow_app/201606060045382gYtJkaTwmRrLq9B.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1","image_experiment":""}}
     */

    private String image;
    private int type;
    private PostBean post;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public PostBean getPost() {
        return post;
    }

    public void setPost(PostBean post) {
        this.post = post;
    }
}
