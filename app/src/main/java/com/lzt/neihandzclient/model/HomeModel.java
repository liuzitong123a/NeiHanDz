package com.lzt.neihandzclient.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 刘子樋 on 2017/4/24.
 */

public class HomeModel {


    /**
     * code : 200
     * list : [{"likeCount":0,"disLikeCount":0,"commentCount":0,"colCount":0,"homeId":349,"homeContent":"这警笛声没谁了","homeurl":"upload/jpg/39.jpg","homePic":"","homeTime":"2017-02-12 11:43:50","user":{"userId":21,"nickName":"ThanksLike","path":"my.png"}},{"likeCount":0,"disLikeCount":0,"commentCount":0,"colCount":0,"homeId":348,"homeContent":"跟同事加完班吃宵夜，他喝多了，回去的路上，他拿着干活用的冲击钻，跟我说这是他的冲锋枪，东一梭子西一梭子的扫射着\u2026\u2026路过派出所时，他突然冲进了院子里，端起冲击钻对着大门口大声的喊：里面的人都听着，你们被包围了，赶快出来缴械投降\u2026\u2026！劳资的酒当时就吓醒了\u2026\u2026","homeurl":"","homePic":"","homeTime":"2017-02-12 12:43:50","user":{"userId":20,"nickName":"K丶无语","path":"my.png"}},{"likeCount":0,"disLikeCount":0,"commentCount":0,"colCount":0,"homeId":347,"homeContent":"内蒙古的习俗","homeurl":"upload/jpg/37.jpg","homePic":"","homeTime":"2017-02-12 13:43:50","user":{"userId":19,"nickName":"无敌的存在","path":"my.png"}},{"likeCount":8,"disLikeCount":0,"commentCount":8,"colCount":0,"homeId":346,"homeContent":"高中的时候去打热水可以用饭卡刷，饭卡是里面包芯片那种。。。割了。。。然后我就把芯片取出来包在自己的校牌里面。每次去打饭刷水都用校牌刷。。。直到有一次我去刷水，被后面排队的一位女同学看到了，然后她惊喜的拿出她的校牌在那里使劲刷，但怎么都刷不出。。。我静静在旁边看了好久。。。好吧！我不认识你同学，我也不打算认识。。","homeurl":"","homePic":"","homeTime":"2017-02-13 07:43:50","user":{"userId":5,"nickName":"拧巴11","path":"my.png"}},{"likeCount":0,"disLikeCount":0,"commentCount":0,"colCount":0,"homeId":345,"homeContent":"新乡辉县打铁花新乡辉县打铁花","homeurl":"upload/jpg/35.jpg","homePic":"","homeTime":"2017-02-13 08:43:50","user":{"userId":18,"nickName":"牛澎","path":"my.png"}}]
     */

    private int code;
    private List<ListBean> list;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean implements Serializable,MultiItemEntity{

        /**
         * likeCount : 0
         * disLikeCount : 0
         * commentCount : 0
         * colCount : 0
         * homeId : 349
         * homeContent : 这警笛声没谁了
         * homeurl : upload/jpg/39.jpg
         * homePic :
         * homeTime : 2017-02-12 11:43:50
         * user : {"userId":21,"nickName":"ThanksLike","path":"my.png"}
         */

        private int likeCount;
        private int disLikeCount;
        private int commentCount;
        private int colCount;
        private int homeId;
        private String homeContent;
        private String homeurl;
        private String homePic;
        private String homeTime;
        private UserBean user;

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public int getDisLikeCount() {
            return disLikeCount;
        }

        public void setDisLikeCount(int disLikeCount) {
            this.disLikeCount = disLikeCount;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public int getColCount() {
            return colCount;
        }

        public void setColCount(int colCount) {
            this.colCount = colCount;
        }

        public int getHomeId() {
            return homeId;
        }

        public void setHomeId(int homeId) {
            this.homeId = homeId;
        }

        public String getHomeContent() {
            return homeContent;
        }

        public void setHomeContent(String homeContent) {
            this.homeContent = homeContent;
        }

        public String getHomeurl() {
            return homeurl;
        }

        public void setHomeurl(String homeurl) {
            this.homeurl = homeurl;
        }

        public String getHomePic() {
            return homePic;
        }

        public void setHomePic(String homePic) {
            this.homePic = homePic;
        }

        public String getHomeTime() {
            return homeTime;
        }

        public void setHomeTime(String homeTime) {
            this.homeTime = homeTime;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        @Override
        public int getItemType() {
            return 0;
        }

        public static class UserBean implements Serializable {
            /**
             * userId : 21
             * nickName : ThanksLike
             * path : my.png
             */

            private int userId;
            private String nickName;
            private String path;

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }
        }
    }
}
