package com.gildedrose;

class GildedRose {

    Item[] items;
    ItemUpdaterFactory itemUpdaterFactory = new ItemUpdaterFactory();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if(item != null){
                itemUpdaterFactory.getFactory(item).updateQuality();
            }
        }
    }
}
