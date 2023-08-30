package com.shazdevelops.texfactoryad;

public class CheckersInfo {

        String checkName, checkStatus, checkWork;

        public CheckersInfo() {
        }

        public CheckersInfo(String checkName, String checkStatus, String checkWork) {
            this.checkName = checkName;
            this.checkStatus = checkStatus;
            this.checkWork = checkWork;
        }

        public String getCheckName() {
            return checkName;
        }

        public void setCheckName(String checkName) {
            this.checkName = checkName;
        }

        public String getCheckStatus() {
            return checkStatus;
        }

        public void setCheckStatus(String checkStatus) {
            this.checkStatus = checkStatus;
        }

        public String getCheckWork() {
            return checkWork;
        }

        public void setCheckWork(String checkWork) {
            this.checkWork = checkWork;
        }
}
