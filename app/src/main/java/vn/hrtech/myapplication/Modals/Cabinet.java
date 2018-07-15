package vn.hrtech.myapplication.Modals;

public class Cabinet {
    private String Id;
    private boolean IsOpened;
    private String GoodsId;
    private String Code;
    private String LocationId;
    private String Name;
    private boolean isHadGoods;
    private Goods Goods;
    private String Location;

    public boolean getIsHadGoods() {
        return isHadGoods;
    }

    public boolean getIsOpened() {
        return IsOpened;
    }

    public void setIsOpened(boolean isOpened){
        this.IsOpened = isOpened;
    }

    public String getName() {
        return Name;
    }

    public String getId() {
        return Id;
    }

    public String getGoodsId() {
        return GoodsId;
    }

    public vn.hrtech.myapplication.Modals.Goods getGoods() {
        return Goods;
    }

    public String getCode() {
        return Code;
    }

    public String getLocation() {
        return Location;
    }

    public String getLocationId() {
        return LocationId;
    }

    public void setGoodsId(String goodsId) {
        GoodsId = goodsId;
    }

    public void setGoods(vn.hrtech.myapplication.Modals.Goods goods) {
        Goods = goods;
    }

    public void setCode(String code) {
        Code = code;
    }

    public void setIsHadGoods(boolean hasGoods) {
        this.isHadGoods = hasGoods;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void setLocationId(String locationId) {
        LocationId = locationId;
    }

    public void setOpened(boolean opened) {
        IsOpened = opened;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }
}
