package com.honghei.gank.bean.zhihunews;

import java.util.List;

/**
 * @author Honghei
 * @time 2017/3/22  14:13
 * @desc ${TODD}
 */
public class NewsDetailBean {


    /**
     * body : <div class="main-wrap content-wrap">
     <div class="headline">

     <div class="img-place-holder"></div>



     </div>

     <div class="content-inner">




     <div class="question">
     <h2 class="question-title">绝对的空无当中是如何诞生宇宙的？</h2>

     <div class="answer">

     <div class="meta">
     <img class="avatar" src="http://pic1.zhimg.com/b02657184_is.jpg">
     <span class="author">Minglei Xiao，</span><span class="bio">物理宅</span>
     </div>

     <div class="content">
     <p>很多人都学过开集这个概念，但很少人真正理解它。</p>
     <p>当我们说这个宇宙的寿命是 100 亿年的时候，我们承认宇宙存在于时间的开集(0,100 亿年)。它的右端不重要，我们主要谈谈它的左端。</p>
     <p>一个开集是没有端点的。</p>
     <p>一个开集是没有端点的。</p>
     <p>一个开集是没有端点的。</p>
     <p>这是一个很简单的事实，可是多少人忽略了它。所谓宇宙的开端的问题其实可以很简单。一个非常可能的答案（物理学暂时没有确定的答案）就是宇宙没有开端。一个很简单的把戏就是重新参数化时间，比如取时间的对数作为新的时间，我们发现这个新的时间可以延伸到负无穷。对于一个延伸到负无穷的时间，你不会去思考它的开端以及开端之前是怎样的吧？这种参数化很耍流氓吗？其实并不。时间的度量并不是一个绝对的东西，即便选取的不是观察者的固有时，你也可以很容易想象这样的场景：（新的）时间向过去（负无穷）无限流淌，而一个观察者的固有时逐渐凝固，它身上所带的表停了，直到过去的尽头。没毛病吧？你问在那尽头之前呢？这问题好么？（和黑洞视界不同的是，虽然以无穷远观察者的时间，视界上的时间停止了，但经过坐标延拓我们可以推测自由下落观察者穿过视界的行为，因为可以证明视界是个坐标奇点。而宇宙的开端很可能是个本性奇点，就像黑洞内的奇点一样，在这样的奇点你无法做坐标延拓的，所以你并不能像对黑洞视界上的自由下落观察者一样推测这个无穷过去观察者在奇点以前的行为。）</p>
     <p>之所以可以这样做，是因为总存在一种参数化（数学上称为微分同胚）把开集映射到无穷，这是拓扑性质决定的。也就是说只要我们假定宇宙存在的时间是个开集，就可以完全避开宇宙开端的问题。</p>
     <p>好，那么宇宙存在的时间是一个开集吗？我觉得可以这么想，我们对宇宙时间的探索总是一步一步往过去推测的，物理理论到了哪一步，我们就理解到哪一步。除非我们完成了物理理论，达到了宇宙的一个闭集开端，对那个开端有了完备的描述，否则我们总是只需要处理一个有着开集时间的宇宙。从认知的角度来说，也许我们永远也只能处理这样的开集。只要仍然留有开集的可能性，那么去讨论宇宙的开端及其之前就是无意义的；而一旦否定了这个可能性，那就意味着我们对那个开端也就已经有了完备的了解。所以这是一个要么没有意义，要么已被解答的问题。它目前的状态是没有意义。</p>
     </div>
     </div>


     <div class="view-more"><a href="http://www.zhihu.com/question/36188282">查看知乎讨论<span class="js-question-holder"></span></a></div>

     </div>


     </div>
     </div>
     * image_source : 《奇异博士》
     * title : 宇宙是怎么开始的？嗯……宇宙其实没有开端
     * image : https://pic3.zhimg.com/v2-3f59f6d680b3ec16f0bda049e4ec4122.jpg
     * share_url : http://daily.zhihu.com/story/9305774
     * js : []
     * ga_prefix : 032213
     * images : ["https://pic1.zhimg.com/v2-ebc1a630b861bdf62396876543291a34.jpg"]
     * type : 0
     * id : 9305774
     * css : ["http://news-at.zhihu.com/css/news_qa.auto.css?v=4b3e3"]
     */

    private String body;
    private String image_source;
    private String title;
    private String image;
    private String share_url;
    private String ga_prefix;
    private int type;
    private int id;
    private List<?> js;
    private List<String> images;
    private List<String> css;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
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

    public List<?> getJs() {
        return js;
    }

    public void setJs(List<?> js) {
        this.js = js;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getCss() {
        return css;
    }

    public void setCss(List<String> css) {
        this.css = css;
    }
}
