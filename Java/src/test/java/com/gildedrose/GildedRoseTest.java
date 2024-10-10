package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void whenItemExpired_thenItemQualityDecreasesFaster() {
        GildedRose app = new GildedRose(new Item[] {new Item("banana", 0, 10)});
        app.updateQuality();

        assertEquals(8, app.items[0].quality);
    }

    @Test
    void whenUpdateQuality_normalItemDecreasesByOne() {
        GildedRose app = new GildedRose(new Item[] {new Item("banana", 5, 5)});
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }

    @Test
    void whenUpdateQuality_thenQualityNeverNegative() {
        GildedRose app = new GildedRose(new Item[] {new Item("banana", 5, 0)});
            app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void whenUpdateQuality_thenBrieQualityIncreasesByOne() {
        GildedRose app = new GildedRose(new Item[] {new Item("Aged Brie", 5, 1)});
            app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void whenUpdateQuality_thenExpiredBrieQualityIncreasesByTwo() {
        GildedRose app = new GildedRose(new Item[] {new Item("Aged Brie", -1, 1)});
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void whenUpdateQuality_thenQualityNotExceed50ifLess() {
        GildedRose app = new GildedRose(new Item[] {new Item("Aged Brie", 5, 49)});
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void whenUpdateQuality_thenQualityNotExceed50() {
        GildedRose app = new GildedRose(new Item[] {new Item("banana", 5, 50)});
        app.updateQuality();
        assertEquals(49, app.items[0].quality);
    }

    @Test
    void whenUpdateQuality_thenSulfurasQualityAndSellInUnchanged() {
        GildedRose app = new GildedRose(new Item[] {new Item("Sulfuras, Hand of Ragnaros", 10, 80)});
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void whenConcertMoreThanTenDays_thenBackstagePassQualityIncreasesByOne() {
        GildedRose app = new GildedRose(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)});
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void whenConcertInTenDays_thenBackstagePassQualityIncreasesByTwo() {
        GildedRose app = new GildedRose(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)});
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void whenConcertInFiveDays_thenBackstagePassQualityIncreasesByThree() {
        GildedRose app = new GildedRose(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)});
            app.updateQuality();
        assertEquals(23, app.items[0].quality);
    }

    @Test
    void whenConcertHappens_thenBackstagePassQualityIsZero() {
        GildedRose app = new GildedRose(new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30)});
            app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void conjuredExpiredTwiceAsFast() {
        Item freshConjured = new Item("Conjured", 5, 10);
        Item expiredConjured =  new Item("Conjured", -1, 10);
        GildedRose app = new GildedRose(new Item[] {freshConjured, expiredConjured});
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
        assertEquals(6, app.items[1].quality);

    }

    @Test
    void toStringTest() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 80);
        assertEquals("Sulfuras, Hand of Ragnaros, 10, 80", item.toString());
    }
}
