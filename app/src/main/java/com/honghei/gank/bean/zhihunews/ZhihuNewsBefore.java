package com.honghei.gank.bean.zhihunews;

import java.util.List;

/**
 * @author Honghei
 * @time 2017/3/18  15:44
 * @desc 之前的信息。
 */
public class ZhihuNewsBefore {


    /**
     * date : 20170318
     * stories : [{"images":["https://pic2.zhimg.com/v2-dcc2361d23820aa53b0972c67b8033c1.jpg"],"type":0,"id":9270660,"ga_prefix":"031814","title":"只想吃点老鼠药自杀，结果非但没死，这药还救了好多人"},{"images":["https://pic4.zhimg.com/v2-a09ec1985f2defc16cfc256f60a1371b.jpg"],"type":0,"id":9288349,"ga_prefix":"031813","title":"装修时没注意这些细节，现在是不是后悔了？"},{"images":["https://pic4.zhimg.com/v2-9d4040d48de38d3fe77fd4f23d6b6d13.jpg"],"type":0,"id":9295187,"ga_prefix":"031812","title":"大误 · 谁还没称霸过 QQ 咋地"},{"title":"江南春天的野菜，比肉还好吃","ga_prefix":"031811","images":["https://pic4.zhimg.com/v2-9c84eed31774aaf43a987963fcd959cb.jpg"],"multipic":true,"type":0,"id":9293223},{"images":["https://pic4.zhimg.com/v2-7d0cb86e4d9ba41a802d0ce8eba02a13.jpg"],"type":0,"id":9288368,"ga_prefix":"031810","title":"中国有哪些好看的科幻小说选集？"},{"images":["https://pic4.zhimg.com/v2-82dd98684cd736415d2e1d01260758cf.jpg"],"type":0,"id":9296169,"ga_prefix":"031809","title":"这里有可能是世界上最深的洞穴，它的名字叫「暗星」"},{"images":["https://pic1.zhimg.com/v2-148c4bf61d517bf56ad0c59be9eb100c.jpg"],"type":0,"id":9292973,"ga_prefix":"031808","title":"票少人多，抢购和拍卖哪个更好？"},{"images":["https://pic3.zhimg.com/v2-fed1f434dd3c4caf35029d9d589ce252.jpg"],"type":0,"id":9296148,"ga_prefix":"031807","title":"演技本质上是一种工作能力，又不仅仅是工作能力那么简单"},{"title":"如何让一辆汽车的内部空间显得更大？","ga_prefix":"031807","images":["https://pic1.zhimg.com/v2-eefe573b411d453c71b2a643c705d8c8.jpg"],"multipic":true,"type":0,"id":9257621},{"images":["https://pic3.zhimg.com/v2-f2068a50f3a36b675ab59097bd99247e.jpg"],"type":0,"id":9296368,"ga_prefix":"031807","title":"Airbnb 有了中国「金主」，它会走 Uber 的老路吗？"},{"images":["https://pic3.zhimg.com/v2-c86626289f8b6de5844ea53ca77b105a.jpg"],"type":0,"id":9295311,"ga_prefix":"031806","title":"瞎扯 · 如何正确地吐槽"}]
     */

    private String date;
    private List<StoriesBean> stories;

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


}
