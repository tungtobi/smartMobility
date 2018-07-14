package vn.hrtech.myapplication.Modals;

public class Order {
    private String name;
    private String id;
    private String describe;
    private boolean isComplete;


    public Order(String name, String id, String describe) {
        this.name = name;
        this.id = id;
        this.describe = describe;
        this.isComplete = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
