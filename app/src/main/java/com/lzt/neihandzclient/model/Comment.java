package com.lzt.neihandzclient.model;

import java.util.List;

/**
 * Created by 刘子樋 on 2017/4/28.
 */

public class Comment {

    /**
     * flag : 10011
     * code : 200
     * list : [{"commentId":21,"commentContent":"666","home":{"homeId":0,"homeContent":"【未南】Pink Cat 渔网袜吊袜带简直不能更羞耻"},"user":{"userId":2,"nickName":"K丶无奈","path":"upload/20170314/7162613d-0356-4d2e-aa50-4682e18461d4.jpg"},"commentDate":"2017-03-12 11:27"},{"commentId":44,"commentContent":"iOS","home":{"homeId":0,"homeContent":"【未南】Pink Cat 渔网袜吊袜带简直不能更羞耻"},"user":{"userId":41,"nickName":"我去","path":"upload/20170313/fbfe23b2-2c1f-4781-8516-9c6b15d3ca10.png"},"commentDate":"2017-03-14 11:48"},{"commentId":45,"commentContent":"6666","home":{"homeId":0,"homeContent":"【未南】Pink Cat 渔网袜吊袜带简直不能更羞耻"},"user":{"userId":41,"nickName":"我去","path":"upload/20170313/fbfe23b2-2c1f-4781-8516-9c6b15d3ca10.png"},"commentDate":"2017-03-15 11:55"}]
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
         * commentId : 21
         * commentContent : 666
         * home : {"homeId":0,"homeContent":"【未南】Pink Cat 渔网袜吊袜带简直不能更羞耻"}
         * user : {"userId":2,"nickName":"K丶无奈","path":"upload/20170314/7162613d-0356-4d2e-aa50-4682e18461d4.jpg"}
         * commentDate : 2017-03-12 11:27
         */

        private int commentId;
        private String commentContent;
        private HomeBean home;
        private UserBean user;
        private String commentDate;

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public String getCommentContent() {
            return commentContent;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }

        public HomeBean getHome() {
            return home;
        }

        public void setHome(HomeBean home) {
            this.home = home;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getCommentDate() {
            return commentDate;
        }

        public void setCommentDate(String commentDate) {
            this.commentDate = commentDate;
        }

        public static class HomeBean {
            /**
             * homeId : 0
             * homeContent : 【未南】Pink Cat 渔网袜吊袜带简直不能更羞耻
             */

            private int homeId;
            private String homeContent;

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
        }

        public static class UserBean {
            /**
             * userId : 2
             * nickName : K丶无奈
             * path : upload/20170314/7162613d-0356-4d2e-aa50-4682e18461d4.jpg
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
