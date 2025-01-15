package com.gildedrose;

public class ConjuredItemUpdater extends ItemUpdater {

    public ConjuredItemUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        setOverflowingQualityToMaxOrMin();
        item.sellIn--;
        item.quality -= 2;
        setOverflowingQualityToMaxOrMin();
    }
}
