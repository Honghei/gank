package com.honghei.gank.bean.daily;

/**
 * @author Honghei
 * @time 2017/4/4  8:55
 * @desc ${TODD}
 */
public class BannersBean {
    /**
     * image : http://img.qdaily.com/article/banner/20170404074644e0HlcYavFAiPROrX.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1
     * type : 2
     * post : {"id":39459,"genre":1,"title":"1998 年，贺雄飞和他自定义为\u201c黑马\u201d的 34 本书 | 畅销书让我们看到了什么样的中国①","description":"一方面回顾这些传奇之书的故事，更重要的当然还是：我们为什么有了如今这样的一个社会，我们曾经历过什么，我们得到和失去了什么，我们积累了什么样的财富和共识，我们何以走到今天。","publish_time":1491261744,"image":"http://img.qdaily.com/article/banner/20170404074644e0HlcYavFAiPROrX.jpg?imageMogr2/auto-orient/thumbnail/!640x380r/gravity/Center/crop/640x380/quality/85/format/jpg/ignore-error/1","start_time":0,"comment_count":0,"praise_count":18,"super_tag":"长文章","page_style":1,"post_id":41055,"appview":"http://app3.qdaily.com/app3/articles/39459.html","film_length":"","datatype":"article","category":{"id":5,"title":"城市","normal":"http://img.qdaily.com/category/icon_black/20160606004532qOnV1WpsEHkJ9Zfr.png?imageMogr2/auto-orient/thumbnail/!128x128r/gravity/Center/crop/128x128/quality/85/ignore-error/1","normal_hl":"http://img.qdaily.com/category/icon_yellow_app/20160606004533uFozK3xI4CHZjfSM.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1","image_lab":"http://img.qdaily.com/category/icon_yellow_app/20160606004533uFozK3xI4CHZjfSM.png?imageMogr2/auto-orient/thumbnail/!160x160r/gravity/Center/crop/160x160/quality/85/ignore-error/1","image_experiment":""}}
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
