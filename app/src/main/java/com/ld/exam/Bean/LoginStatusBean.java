package com.ld.exam.Bean;

/**登录状态实体类
 * Created by hz on 2017/8/14.
 */

public class LoginStatusBean {

    /**
     * status : 0
     * message :
     * data : {"version":"3","gameId":"jtemp","code_url":"http://115.28.136.52:9090/zoo/v1/game_code_170729015725.zip","update_url":"http://115.28.136.52:9090/zoo/v1/","customParams":{}}
     */

    private String status;
    private String message;
    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * version : 3
         * gameId : jtemp
         * code_url : http://115.28.136.52:9090/zoo/v1/game_code_170729015725.zip
         * update_url : http://115.28.136.52:9090/zoo/v1/
         * customParams : {}
         */

        private String version;
        private String gameId;
        private String code_url;
        private String update_url;
        private CustomParamsBean customParams;

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getGameId() {
            return gameId;
        }

        public void setGameId(String gameId) {
            this.gameId = gameId;
        }

        public String getCode_url() {
            return code_url;
        }

        public void setCode_url(String code_url) {
            this.code_url = code_url;
        }

        public String getUpdate_url() {
            return update_url;
        }

        public void setUpdate_url(String update_url) {
            this.update_url = update_url;
        }

        public CustomParamsBean getCustomParams() {
            return customParams;
        }

        public void setCustomParams(CustomParamsBean customParams) {
            this.customParams = customParams;
        }

        public static class CustomParamsBean {
        }
    }
}
