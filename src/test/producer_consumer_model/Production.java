package test.producer_consumer_model;

/*
假设为产品为笔
 */

public class Production {
    private String type = "";
    private String color = "";
    private long code = 0; // 产品编号
    private boolean isProduced = false; // 是否生产完成 初始状态为未生产状态
    private boolean isContinueProduce = true; // 是否停产该产品

    public void setContinueProduce(boolean continueProduce) {
        isContinueProduce = continueProduce;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Production() {
    }

    public boolean isContinueProduce() {
        return isContinueProduce;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setProduced(boolean produced) {
        isProduced = produced;
    }

    public boolean isProduced() {
        return isProduced;
    }

    @Override
    public String toString() {
        return color + type + "-" + code;
    }
}
