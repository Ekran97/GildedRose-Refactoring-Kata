package com.gildedrose

class GildedRose(var items: List<Item>) {

fun updateQuality(){
    for (item in items) {
        setOverflowingQualityToMaxOrMin(item)
        when (item.name) {
            Constants.SULFURAS -> {}
            Constants.CONJURED -> {
                item.sellIn--
                item.quality -= 2
            }

            Constants.AGED_BRIE -> {
                item.sellIn--
                item.quality++
            }

            Constants.BACKSTAGE_PASSES -> {
                item.sellIn--
                updateBackstagePasseQuality(item)
            }

            else -> {
                item.sellIn--
                item.quality--
            }
        }
        setOverflowingQualityToMaxOrMin(item)
    }
}

     private fun setOverflowingQualityToMaxOrMin(item: Item) {
        if (Constants.SULFURAS == item.name) {
            item.quality = Constants.SULFURAS_QUALITY
            return
        }
        if (item.quality > Constants.MAX_QUALITY) {
            item.quality = Constants.MAX_QUALITY
        } else if (item.quality < Constants.MIN_QUALITY) {
            item.quality = Constants.MIN_QUALITY
        }
    }

     private fun updateBackstagePasseQuality(item: Item) {
        if (item.sellIn < 0) {
            item.quality = 0
        } else if (item.sellIn <= Constants.FIVE_DAYS) {
            item.quality += 3
        } else if (item.sellIn <= Constants.TEN_DAYS) {
            item.quality += 2
        } else {
            item.quality++
        }
    }


    /*fun updateQuality() {
        for (i in items.indices) {
            if (items[i].name != "Aged Brie" && items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                if (items[i].quality > 0) {
                    if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                        items[i].quality--
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality++

                    if (items[i].name == "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality++
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality++
                            }
                        }
                    }
                }
            }

            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                items[i].sellIn--
            }

            if (items[i].sellIn < 0) {
                if (items[i].name != "Aged Brie") {
                    if (items[i].name != "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].quality > 0) {
                            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                                items[i].quality--
                            }
                        }
                    } else {
                        items[i].quality = 0
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality++
                    }
                }
            }
        }
    }*/

}

