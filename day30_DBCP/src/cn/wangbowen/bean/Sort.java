package cn.wangbowen.bean;
/*
bean有的地方也叫domain
规范：
    变量尽量和数据库的字段名一致
    一定要有一个空的构造参数
    get\set方法
    toString最好也弄一下
 */
public class Sort {
    private int sid;
    private String sname;
    private double sprice;
    private String sdesc;

    public Sort() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public double getSprice() {
        return sprice;
    }

    public void setSprice(double sprice) {
        this.sprice = sprice;
    }

    public String getSdesc() {
        return sdesc;
    }

    public void setSdesc(String sdesc) {
        this.sdesc = sdesc;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sprice=" + sprice +
                ", sdesc='" + sdesc + '\'' +
                '}';
    }
}
