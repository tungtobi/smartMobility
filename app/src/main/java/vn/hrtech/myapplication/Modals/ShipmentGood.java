package vn.hrtech.myapplication.Modals;

public class ShipmentGood {
    private String Id;
    private String ShipmentId;
    private String GoodsId;
    private Goods Goods;
    private String Shipment;

    public String getId() {
        return Id;
    }

    public vn.hrtech.myapplication.Modals.Goods getGoods() {
        return Goods;
    }

    public String getGoodsId() {
        return GoodsId;
    }

    public String getShipment() {
        return Shipment;
    }

    public String getShipmentId() {
        return ShipmentId;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setGoods(vn.hrtech.myapplication.Modals.Goods goods) {
        Goods = goods;
    }

    public void setGoodsId(String goodsId) {
        GoodsId = goodsId;
    }

    public void setShipment(String shipment) {
        Shipment = shipment;
    }

    public void setShipmentId(String shipmentId) {
        ShipmentId = shipmentId;
    }
}
