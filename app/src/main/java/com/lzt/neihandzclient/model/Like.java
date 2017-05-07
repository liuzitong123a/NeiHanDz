package com.lzt.neihandzclient.model;

import java.util.List;

/**
 * Created by 刘子樋 on 2017/4/28.
 */

public class Like {

    /**
     * flag : 10011
     * code : 200
     * list : [{"favourId":64,"user":{"userId":41}},{"favourId":41,"user":{"userId":2}}]
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
         * favourId : 64
         * user : {"userId":41}
         */

        private int favourId;
        private UserBean user;

        public int getFavourId() {
            return favourId;
        }

        public void setFavourId(int favourId) {
            this.favourId = favourId;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
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
    }
}
