package com.gildedrose;

public class ItemUpdater {

    protected Item item;

    public ItemUpdater(Item item){
        this.item = item;
    }

    public void updateItem(){
        setOverflowingQualityToMaxOrMin();
        updateQuality();
        setOverflowingQualityToMaxOrMin();
    }

     protected void updateQuality(){
        item.sellIn--;
        item.quality--;
    }

    public void setOverflowingQualityToMaxOrMin(){
        if (item.quality > Constants.MAX_QUALITY) {
            item.quality = Constants.MAX_QUALITY;
        } else if (item.quality < Constants.MIN_QUALITY) {
            item.quality = Constants.MIN_QUALITY;
        }
    }
}
