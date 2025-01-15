package com.gildedrose;

public class BackstagePassItemUpdater extends ItemUpdater {

    public BackstagePassItemUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.sellIn <= Constants.FIVE_DAYS) {
            item.quality = item.quality + 3;
        } else if (item.sellIn <= Constants.TEN_DAYS) {
            item.quality = item.quality + 2;
        } else {
            item.quality++;
        }
    }
}
