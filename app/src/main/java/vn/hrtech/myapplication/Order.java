package vn.hrtech.myapplication;

public class Order {
    private String name;
    private String id;
    private String describe;

    public Order(String name, String id, String describe) {
        this.name = name;
        this.id = id;
        this.describe = describe;
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
}
