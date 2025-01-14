package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun item() {
        val items = listOf(Item("item", 5, 5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(4, items[0].sellIn)
        assertEquals(4, items[0].quality)
    }

    @Test
    fun item_quality_more_than_50() {
        val items = listOf(Item("item", 5, 60))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(4, items[0].sellIn)
        assertEquals(49, items[0].quality)
    }

    @Test
    fun item_quality_less_than_0() {
        val items = listOf(Item("item", 5, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(4, items[0].sellIn)
        assertEquals(0, items[0].quality)
    }

    @Test
    fun sulfuras() {
        val items = listOf(Item(Constants.SULFURAS, 5, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(5, items[0].sellIn)
        assertEquals(80, items[0].quality)
    }

    @Test
    fun conjured() {
        val items = listOf(Item(Constants.CONJURED, 5, 5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(4, items[0].sellIn)
        assertEquals(3, items[0].quality)
    }

    @Test
    fun conjured_quality_more_than_50() {
        val items = listOf(Item(Constants.CONJURED, 5, 60))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(4, items[0].sellIn)
        assertEquals(48, items[0].quality)
    }

    @Test
    fun conjured_quality_less_than_0() {
        val items = listOf(Item(Constants.CONJURED, 5, 1))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(4, items[0].sellIn)
        assertEquals(0, items[0].quality)
    }

    @Test
    fun aged_brie() {
        val items = listOf(Item(Constants.AGED_BRIE, 5, 5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(4, items[0].sellIn)
        assertEquals(6, items[0].quality)
    }

    @Test
    fun aged_brie_quality_more_than_50() {
        val items = listOf(Item(Constants.AGED_BRIE, 5, 60))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(4, items[0].sellIn)
        assertEquals(50, items[0].quality)
    }

    @Test
    fun aged_brie_quality_less_than_0() {
        val items = listOf(Item(Constants.AGED_BRIE, 5, -5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(4, items[0].sellIn)
        assertEquals(1, items[0].quality)
    }

    @Test
    fun backstage_passe_normal() {
        val items = listOf(Item(Constants.BACKSTAGE_PASSES, 20, 5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(19, items[0].sellIn)
        assertEquals(6, items[0].quality)
    }

    @Test
    fun backstage_passe_sellIn_less_than_10_days() {
        val items = listOf(Item(Constants.BACKSTAGE_PASSES, 10, 5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, items[0].sellIn)
        assertEquals(7, items[0].quality)
    }

    @Test
    fun backstage_passe_sellIn_less_than_5_days() {
        val items = listOf(Item(Constants.BACKSTAGE_PASSES, 5, 5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(4, items[0].sellIn)
        assertEquals(8, items[0].quality)
    }

    @Test
    fun backstage_passe_after_concert() {
        val items = listOf(Item(Constants.BACKSTAGE_PASSES, 0, 5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, items[0].sellIn)
        assertEquals(0, items[0].quality)
    }

    @Test
    fun backstage_passe_quality_more_than_50() {
        val items = listOf(Item(Constants.BACKSTAGE_PASSES, 5, 60))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(4, items[0].sellIn)
        assertEquals(50, items[0].quality)
    }

    @Test
    fun backstage_passe_quality_less_than_0() {
        val items = listOf(Item(Constants.BACKSTAGE_PASSES, 20, -5))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(19, items[0].sellIn)
        assertEquals(1, items[0].quality)
    }

}


