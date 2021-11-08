package org.example.ssm.pojo;

public class UsersExt extends Users{

    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "UsersExt{" +
                "ip='" + ip + '\'' +
                '}';
    }
}
