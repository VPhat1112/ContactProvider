package com.example.contactprovider;

public class Item
{
    private String Name;
    private String itemInfo;
    public Item(String itemName, String itemInfo){
        this.Name=itemName;
        this.itemInfo=itemInfo;
    }

    public String getItemName() {
        return Name;
    }

    public void setItemName(String itemName) {
        this.Name = itemName;
    }


    public String getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(String itemInfo) {
        this.itemInfo = itemInfo;
    }
}

