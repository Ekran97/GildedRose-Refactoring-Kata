package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    @Test
    void item() {
        Item[] items = new Item[] { new Item("item", 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(4, items[0].quality);
    }

    @Test
    void items() {
        Item[] items = new Item[] {
            new Item("item 1", 5, 5) ,
            new Item("item 2", 4, 8) ,
            new Item("item 3", 10, 10) ,
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(4, items[0].quality);
        assertEquals(3, items[1].sellIn);
        assertEquals(7, items[1].quality);
        assertEquals(9, items[2].sellIn);
        assertEquals(9, items[2].quality);
    }

    @Test
    void item_null() {
        Item[] items = new Item[] { null };
        GildedRose app = new GildedRose(items);
        assertDoesNotThrow(app::updateQuality);
    }

    @Test
    void item_quality_more_than_50() {
        Item[] items = new Item[] { new Item("item", 5, 60) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(49, items[0].quality);
    }

    @Test
    void item_quality_less_than_0() {
        Item[] items = new Item[] { new Item("item", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void sulfuras() {
        Item[] items = new Item[] { new Item(Constants.SULFURAS, 5, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    @Test
    void conjured() {
        Item[] items = new Item[] { new Item(Constants.CONJURED, 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(3, items[0].quality);
    }

    @Test
    void conjured_quality_more_than_50() {
        Item[] items = new Item[] { new Item(Constants.CONJURED, 5, 60) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(48, items[0].quality);
    }

    @Test
    void conjured_quality_less_than_0() {
        Item[] items = new Item[] { new Item(Constants.CONJURED, 5, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void aged_brie() {
        Item[] items = new Item[] { new Item(Constants.AGED_BRIE, 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(6, items[0].quality);
    }

    @Test
    void aged_brie_quality_more_than_50() {
        Item[] items = new Item[] { new Item(Constants.AGED_BRIE, 5, 60) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void aged_brie_quality_less_than_0() {
        Item[] items = new Item[] { new Item(Constants.AGED_BRIE, 5, -5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(1, items[0].quality);
    }

    @Test
    void backstage_passe_normal() {
        Item[] items = new Item[] { new Item(Constants.BACKSTAGE_PASSES, 20, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19, items[0].sellIn);
        assertEquals(6, items[0].quality);
    }

    @Test
    void backstage_passe_sellIn_less_than_10_days() {
        Item[] items = new Item[] { new Item(Constants.BACKSTAGE_PASSES, 10, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, items[0].sellIn);
        assertEquals(7, items[0].quality);
    }

    @Test
    void backstage_passe_sellIn_less_than_5_days() {
        Item[] items = new Item[] { new Item(Constants.BACKSTAGE_PASSES, 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(8, items[0].quality);
    }

    @Test
    void backstage_passe_after_concert() {
        Item[] items = new Item[] { new Item(Constants.BACKSTAGE_PASSES, 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void backstage_passe_quality_more_than_50() {
        Item[] items = new Item[] { new Item(Constants.BACKSTAGE_PASSES, 5, 60) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void backstage_passe_quality_less_than_0() {
        Item[] items = new Item[] { new Item(Constants.BACKSTAGE_PASSES, 20, -5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(19, items[0].sellIn);
        assertEquals(1, items[0].quality);
    }

}
