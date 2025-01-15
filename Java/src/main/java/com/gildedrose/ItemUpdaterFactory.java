package com.gildedrose;

public class ItemUpdaterFactory {

    public ItemUpdater getFactory(Item item) {
        switch (item.name) {
            case Constants.SULFURAS:
                return new SulfurasItemUpdater(item);

            case Constants.CONJURED:
                return new ConjuredItemUpdater(item);

            case Constants.AGED_BRIE:
                return new AgedBrieItemUpdater(item);

            case Constants.BACKSTAGE_PASSES:
                return new BackstagePassItemUpdater(item);

            default:
                return new ItemUpdater(item);
        }
    }
}
