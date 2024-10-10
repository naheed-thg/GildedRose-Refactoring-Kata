package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item item : items) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn--;
                switch (item.name) {
                case "Aged Brie":
                    item.quality++;
                    if (item.sellIn < 0) item.quality++;
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    item.quality++;
                    if (item.sellIn <= 10) item.quality++;
                    if (item.sellIn <= 5) item.quality++;
                    if (item.sellIn < 0) item.quality = 0;
                    break;
                case "Conjured":
                    if (item.sellIn < 0) item.quality -= 4;
                    else item.quality -= 2;
                    break;
                default:
                    if (item.sellIn < 0) item.quality -= 2;
                    else item.quality--;

                }
                item.quality = Math.max(item.quality, 0);
                item.quality = Math.min(item.quality, 50);
            }


//            if (!item.name.equals("Aged Brie")
//                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                if (item.quality > 0) {
//                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
//                        item.quality = item.quality - 1;
//                    }
//                }
//            } else {
//                if (item.quality < 50) {
//                    item.quality = item.quality + 1;
//
//                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (item.sellIn < 11) {
//                            if (item.quality < 50) {
//                                item.quality = item.quality + 1;
//                            }
//                        }
//
//                        if (item.sellIn < 6) {
//                            if (item.quality < 50) {
//                                item.quality = item.quality + 1;
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
//                item.sellIn = item.sellIn - 1;
//            }
//
//            if (item.sellIn < 0) {
//                if (!item.name.equals("Aged Brie")) {
//                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//                        if (item.quality > 0) {
//                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
//                                item.quality = item.quality - 1;
//                            }
//                        }
//                    } else {
//                        item.quality = 0;
//                    }
//                } else {
//                    if (item.quality < 50) {
//                        item.quality = item.quality + 1;
//                    }
//                }
//            }
        }
    }
}
