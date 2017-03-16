package com.honghei.gank.bean.zhihunews;

import java.util.List;

/**
 * @author Honghei
 * @time 2017/3/14  13:59
 * @desc ${TODD}
 */
public class ZhihuNewsItem {

    /**
     * date : 20170314
     * stories : [{"images":["http://pic4.zhimg.com/4f11c1e10f7175c75959f31888c775af.jpg"],"type":0,"id":9284718,"ga_prefix":"031413","title":"影视剧里的婴儿都是哪里找来的？"},{"images":["http://pic4.zhimg.com/13035d06062f880860148e0b941f8467.jpg"],"type":0,"id":9286838,"ga_prefix":"031412","title":"大误 · 我妈生日那天，我死了"},{"title":"这样的配置让 30 平米的小公寓「蜗居但不将就」","ga_prefix":"031411","images":["http://pic1.zhimg.com/a0e15e91e5fcfeaad32d1370b1581968.jpg"],"multipic":true,"type":0,"id":9285252},{"images":["http://pic4.zhimg.com/4829da1846ecfff7cb65619cc61cff6f.jpg"],"type":0,"id":9285696,"ga_prefix":"031410","title":"年轻人，你爱喝茶吗？"},{"images":["http://pic3.zhimg.com/89b06f590455976692a0f837e330e476.jpg"],"type":0,"id":9285552,"ga_prefix":"031409","title":"西方国家福利那么好，是否削弱了人们创业赚钱的热情？"},{"title":"已经建了 134 年的这座烂尾楼，每个细节都迷人","ga_prefix":"031408","images":["http://pic2.zhimg.com/4043435e5a0a441cbf72d86d356dc111.jpg"],"multipic":true,"type":0,"id":9285906},{"images":["http://pic4.zhimg.com/75d4107b622fdc7ab0ea9039cd3b95cb.jpg"],"type":0,"id":9284955,"ga_prefix":"031407","title":"理财不仅仅是投资，那理财规划到底包括哪些内容？"},{"images":["http://pic3.zhimg.com/9dfc1e72671e0e4942ba7700f771100e.jpg"],"type":0,"id":9285562,"ga_prefix":"031407","title":"京东到底赚没赚钱？看你怎么算"},{"images":["http://pic1.zhimg.com/536575789ad9d876ba7fea54f566bba0.jpg"],"type":0,"id":9284572,"ga_prefix":"031407","title":"共享单车火了，房地产变了，消费习惯变了，整个城市可能都变了"},{"images":["http://pic3.zhimg.com/f11577fddf1ea3f708ac17c2b208b8c6.jpg"],"type":0,"id":9284710,"ga_prefix":"031406","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic1.zhimg.com/48d590db8d0359b77584d1cfbf2ff3e8.jpg","type":0,"id":9285562,"ga_prefix":"031407","title":"京东到底赚没赚钱？看你怎么算"},{"image":"http://pic4.zhimg.com/53ed0d4314ca415bd8108cd82be1e6a7.jpg","type":0,"id":9284277,"ga_prefix":"031314","title":"咪蒙：网红，病人，潮水的一种方向"},{"image":"http://pic2.zhimg.com/84353c2248ccae0a67e62ceb4ab9f599.jpg","type":0,"id":9284572,"ga_prefix":"031407","title":"共享单车火了，房地产变了，消费习惯变了，整个城市可能都变了"},{"image":"http://pic1.zhimg.com/001b625618b5fee72949d2ff24abdf44.jpg","type":0,"id":9284234,"ga_prefix":"031318","title":"推荐一部真人秀，看完好想删了朋友圈"},{"image":"http://pic2.zhimg.com/2d52e543c6c988330642b28e8f1ff3bd.jpg","type":0,"id":9281775,"ga_prefix":"031313","title":"留学在俄罗斯，发现俄罗斯人真的很爱喝酒"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * images : ["http://pic4.zhimg.com/4f11c1e10f7175c75959f31888c775af.jpg"]
         * type : 0
         * id : 9284718
         * ga_prefix : 031413
         * title : 影视剧里的婴儿都是哪里找来的？
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : http://pic1.zhimg.com/48d590db8d0359b77584d1cfbf2ff3e8.jpg
         * type : 0
         * id : 9285562
         * ga_prefix : 031407
         * title : 京东到底赚没赚钱？看你怎么算
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
