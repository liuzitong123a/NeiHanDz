package com.lzt.neihandzclient.model;

import java.util.List;

/**
 * Created by 刘子樋 on 2017/4/28.
 */

public class Attention {


    /**
     * flag : 10011
     * code : 200
     * list : [{"attentionId":43,"user":{"userId":11,"nickName":"莹宝儿啊","path":"my.png"},"myId":0},{"attentionId":61,"user":{"userId":20,"nickName":"K丶无语","path":"my.png"},"myId":0},{"attentionId":15,"user":{"userId":5,"nickName":"拧巴11","path":"my.png"},"myId":0}]
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
         * attentionId : 43
         * user : {"userId":11,"nickName":"莹宝儿啊","path":"my.png"}
         * myId : 0
         */

        private int attentionId;
        private UserBean user;
        private int myId;

        public int getAttentionId() {
            return attentionId;
        }

        public void setAttentionId(int attentionId) {
            this.attentionId = attentionId;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public int getMyId() {
            return myId;
        }

        public void setMyId(int myId) {
            this.myId = myId;
        }

        public static class UserBean {
            /**
             * userId : 11
             * nickName : 莹宝儿啊
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
