package com.shazdevelops.texfactoryad;

public class WorkerInfo
{

    String status;
    String wuid;
    String ke;
    String name;
    String kw3;
    String work;
    String reason;
    int workerNumber;
    int def1,def2,def3,def4,def5,def6,def7,def8;

    public WorkerInfo() {
    }

    public WorkerInfo(int workerNumber, String status, String wuid,String ke,String name,String work,String reason, String kw3,int def1,int def2
            ,int def3,int def4,int def5,int def6,int def7,int def8) {
        this.workerNumber = workerNumber;
        this.status = status;
        this.wuid = wuid;
        this.ke=ke;
        this.name=name;
        this.def1=def1;
        this.def2=def2;
        this.def3=def3;
        this.def4=def4;
        this.def5=def5;
        this.def6=def6;
        this.def7=def7;
        this.def8=def8;
        this.work=work;
        this.kw3=kw3;
        this.reason=reason;
    }

    public String getKw3() {
        return kw3;
    }



    public void setKw3(String kw3) {
        this.kw3 = kw3;
    }

    public int getDef1() {
        return def1;
    }

    public void setDef1(int def1) {
        this.def1 = def1;
    }

    public int getDef2() {
        return def2;
    }

    public void setDef2(int def2) {
        this.def2 = def2;
    }

    public int getDef3() {
        return def3;
    }

    public void setDef3(int def3) {
        this.def3 = def3;
    }

    public int getDef4() {
        return def4;
    }

    public void setDef4(int def4) {
        this.def4 = def4;
    }

    public int getDef5() {
        return def5;
    }

    public void setDef5(int def5) {
        this.def5 = def5;
    }

    public int getDef6() {
        return def6;
    }

    public void setDef6(int def6) {
        this.def6 = def6;
    }

    public int getDef7() {
        return def7;
    }

    public void setDef7(int def7) {
        this.def7 = def7;
    }

    public int getDef8() {
        return def8;
    }

    public void setDef8(int def8) {
        this.def8 = def8;
    }

    public String getWork() {
        return work;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKe() {
        return ke;
    }

    public void setKe(String ke) {
        this.ke = ke;
    }

    public int getWorkerNumber() {
        return workerNumber;
    }

    public String getWuid() {
        return wuid;
    }

    public void setWuid(String wuid) {
        this.wuid = wuid;
    }

    public void setWorkerNumber(int workerNumber) {
        this.workerNumber = workerNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
