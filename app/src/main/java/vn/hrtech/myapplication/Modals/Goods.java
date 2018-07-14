package vn.hrtech.myapplication.Modals;

import java.util.ArrayList;

public class Goods {
    private String Id;
    private String IdReceiver;
    private String IdSender;
    private String Name;
    private String Status;
    private String AddressRecive;
    private ArrayList<String> cabinetEntities;
    private ArrayList<String> scaleEntities;
    private ArrayList<String> shipmentGoodEntities;

    public int getStatus() {
        if (Status != null) {
            return Integer.parseInt(Status);
        } else {
            return -1;
        }
    }

    public String getIdSender() {
        return IdSender;
    }

    public String getIdReceiver() {
        return IdReceiver;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getAddressRecive() {
        return AddressRecive;
    }

    public ArrayList<String> getCabinetEntities() {
        return cabinetEntities;
    }


    public void setIdSender(String idSender) {
        IdSender = idSender;
    }

    public void setIdReceiver(String idReceiver) {
        IdReceiver = idReceiver;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setId(String id) {
        Id = id;
    }

    public ArrayList<String> getScaleEntities() {
        return scaleEntities;
    }

    public ArrayList<String> getShipmentGoodEntities() {
        return shipmentGoodEntities;
    }

    public void setShipmentGoodEntities(ArrayList<String> shipmentGoodEntities) {
        this.shipmentGoodEntities = shipmentGoodEntities;
    }

    public void setScaleEntities(ArrayList<String> scaleEntities) {
        this.scaleEntities = scaleEntities;
    }

    public void setCabinetEntities(ArrayList<String> cabinetEntities) {
        this.cabinetEntities = cabinetEntities;
    }

    public void setAddressRecive(String addressRecive) {
        AddressRecive = addressRecive;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
