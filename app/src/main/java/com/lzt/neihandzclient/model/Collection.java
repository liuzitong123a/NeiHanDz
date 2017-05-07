package com.lzt.neihandzclient.model;

import java.util.List;

/**
 * Created by 刘子樋 on 2017/4/28.
 */

public class Collection {

    /**
     * flag : 10013
     * code : 200
     * list : [{"collectionId":5,"user":{"userId":41},"home":{"homeId":228,"homeContent":"在我和媳妇闺蜜低三下四的肯求下，媳妇终于肯原谅我们犯下的错误了。她闺蜜看了我一眼，发誓说：\u201c不思从前，忘掉过去，旧事不提，情断义绝！\u201d我表示说：\u201c真心悔改，后悔当日，旧情不再，永不私会！\u201d回到家，媳妇叫我去举着脸盆跪着去。她冷笑着说：\u201c你们两个酸文人跟我玩花花肠子，一个藏头\u2018不忘旧情\u2019，一个藏尾\u2018改日再会\u2019，奸夫淫妇，看我慢慢收拾你们！","homeurl":"","homePic":"","homeTime":"2017-02-12 13:43:50","user":{"userId":41}}}]
     */

    private int flag;
    private int code;
    private List<ListBean> list;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

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

    public static class ListBean {
        /**
         * collectionId : 5
         * user : {"userId":41}
         * home : {"homeId":228,"homeContent":"在我和媳妇闺蜜低三下四的肯求下，媳妇终于肯原谅我们犯下的错误了。她闺蜜看了我一眼，发誓说：\u201c不思从前，忘掉过去，旧事不提，情断义绝！\u201d我表示说：\u201c真心悔改，后悔当日，旧情不再，永不私会！\u201d回到家，媳妇叫我去举着脸盆跪着去。她冷笑着说：\u201c你们两个酸文人跟我玩花花肠子，一个藏头\u2018不忘旧情\u2019，一个藏尾\u2018改日再会\u2019，奸夫淫妇，看我慢慢收拾你们！","homeurl":"","homePic":"","homeTime":"2017-02-12 13:43:50","user":{"userId":41}}
         */

        private int collectionId;
        private UserBean user;
        private HomeBean home;

        public int getCollectionId() {
            return collectionId;
        }

        public void setCollectionId(int collectionId) {
            this.collectionId = collectionId;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public HomeBean getHome() {
            return home;
        }

        public void setHome(HomeBean home) {
            this.home = home;
        }

        public static class UserBean {
            /**
             * userId : 41
             */

            private int userId;

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }
        }

        public static class HomeBean {
            /**
             * homeId : 228
             * homeContent : 在我和媳妇闺蜜低三下四的肯求下，媳妇终于肯原谅我们犯下的错误了。她闺蜜看了我一眼，发誓说：“不思从前，忘掉过去，旧事不提，情断义绝！”我表示说：“真心悔改，后悔当日，旧情不再，永不私会！”回到家，媳妇叫我去举着脸盆跪着去。她冷笑着说：“你们两个酸文人跟我玩花花肠子，一个藏头‘不忘旧情’，一个藏尾‘改日再会’，奸夫淫妇，看我慢慢收拾你们！
             * homeurl :
             * homePic :
             * homeTime : 2017-02-12 13:43:50
             * user : {"userId":41}
             */

            private int homeId;
            private String homeContent;
            private String homeurl;
            private String homePic;
            private String homeTime;
            private UserBeanX user;

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

            public UserBeanX getUser() {
                return user;
            }

            public void setUser(UserBeanX user) {
                this.user = user;
            }

            public static class UserBeanX {
                /**
                 * userId : 41
                 */

                private int userId;

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }
            }
        }
    }
}
