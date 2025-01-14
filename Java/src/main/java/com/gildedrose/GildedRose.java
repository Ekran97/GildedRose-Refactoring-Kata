package com.gildedrose;

class GildedRose {
    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;
    public static final int SULFURAS_QUALITY = 80;
    public static final int TEN_DAYS = 10;
    public static final int FIVE_DAYS = 5;

    public static final String BACKSTAGE_PASSES = "Backstage passes";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras";
    public static final String CONJURED = "Conjured item";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item == null) continue;
            setOverflowingQualityToMaxOrMin(item);
            switch (item.name) {
                case SULFURAS:
                    break;
                case CONJURED:
                    item.sellIn--;
                    item.quality -= 2;
                    break;
                case AGED_BRIE:
                    item.sellIn--;
                    item.quality++;
                    break;
                case BACKSTAGE_PASSES:
                    item.sellIn--;
                    updateBackstagePasseQuality(item);
                    break;
                default:
                    item.sellIn--;
                    item.quality--;
            }
            setOverflowingQualityToMaxOrMin(item);
        }
    }

    private void setOverflowingQualityToMaxOrMin(Item item) {
        if (SULFURAS.equals(item.name)) {
            item.quality = SULFURAS_QUALITY;
            return;
        }
        if (item.quality > MAX_QUALITY) {
            item.quality = MAX_QUALITY;
        } else if (item.quality < MIN_QUALITY) {
            item.quality = MIN_QUALITY;
        }
    }

    private void updateBackstagePasseQuality(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.sellIn <= FIVE_DAYS) {
            item.quality = item.quality + 3;
        } else if (item.sellIn <= TEN_DAYS) {
            item.quality = item.quality + 2;
        } else {
            item.quality++;
        }
    }

/*    public void updateQuality_old() {
        for (Item item : items) {
            setOverflowingQualityToMaxOrMin(item);
            if (!item.name.equals(AGED_BRIE)
                && !item.name.equals(BACKSTAGE_PASSES)) {
                if (item.quality > MIN_QUALITY) {
                    if (!item.name.equals(SULFURAS)) {
                        item.quality--;
                    }
                }
            } else {
                if (item.quality < MAX_QUALITY) {
                    item.quality++;

                    if (item.name.equals(BACKSTAGE_PASSES)) {
                        if (item.sellIn <= TEN_DAYS) {
                            if (item.quality < MAX_QUALITY) {
                                item.quality++;
                            }
                        }

                        if (item.sellIn <= FIVE_DAYS) {
                            if (item.quality < MAX_QUALITY) {
                                item.quality++;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals(SULFURAS)) {
                item.sellIn--;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(AGED_BRIE)) {
                    if (!item.name.equals(BACKSTAGE_PASSES)) {
                        if (item.quality > MIN_QUALITY) {
                            if (!item.name.equals(SULFURAS)) {
                                item.quality--;
                            }
                        }
                    } else {
                        item.quality = MIN_QUALITY;
                    }
                } else {
                    if (item.quality < MAX_QUALITY) {
                        item.quality++;
                    }
                }
            }
        }
    }*/
}
