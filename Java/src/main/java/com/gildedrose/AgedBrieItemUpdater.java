package com.gildedrose;

public class AgedBrieItemUpdater extends ItemUpdater {

    public AgedBrieItemUpdater(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        item.sellIn--;
        item.quality++;
    }
}
