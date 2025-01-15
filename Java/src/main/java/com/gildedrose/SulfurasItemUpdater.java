package com.gildedrose;

public class SulfurasItemUpdater extends ItemUpdater {

    public SulfurasItemUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
    }

    @Override
    public void setOverflowingQualityToMaxOrMin() {
        item.quality = Constants.SULFURAS_QUALITY;
    }
}