package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    // assumed called daily
    public void updateQuality() {
        for (Item item: items) {
            // Item is NOT "Aged Brie" and NOT "Backstage passes"
            // "Aged Brie" will increase in quality rather then decrease
            // "Backstage passes" increase in quality like Brie but slightly differently
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                // quality cannot be negative so do nothing
                if (item.quality > 0) {
                    // if not "Sulfuras" decrease quality. Sulfuras will always have
                    // quality and ready to sell.
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        // Quality increases daily
                        item.quality = item.quality - 1;
                    }
                }
                // Item is "Aged Brie" or "Backstage passes"
            } else {
                // quality cannot be more than 50
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                    // Item is "Backstage passes"
                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        // increase quality by 2 when less than 11 days left (max 10)
                        if (item.sellIn < 11) {
                            // "Backstage passes" cannot be more than 50
                            if (item.quality < 50) {
                                // This increment needs to work with first increment of quality
                                // while still making sure quality is max 50
                                item.quality = item.quality + 1;
                            }
                        }

                        // increase quality by 3 when less than 6 days left
                        if (item.sellIn < 6) {
                            // "Backstage passes" cannot be more than 50
                            if (item.quality < 50) {
                                // This increment needs to work with previous 2 increment of quality
                                // while still making sure quality is max 50
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            // All items except "Sulfuras"
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                // Decrease the sell in days by 1.
                item.sellIn = item.sellIn - 1;
            }

            // If sellin days is less than 1
            if (item.sellIn < 0) {
                //Item is NOT "Aged Brie"
                if (!item.name.equals("Aged Brie")) {
                    //Item is NOT "Backstage passes" (and NOT "Aged Brie")
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        // Item has quality more than 0
                        if (item.quality > 0) {
                            // Item is NOT "Sulfuras"
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                // Decrease the item quality by 1.
                                item.quality = item.quality - 1;
                            }
                        }
                    //Item is "Backstage passes"
                    } else {
                        // Item  quality = 0
                        item.quality = 0;
                    }
                 // Item is "Aged Brie"
                } else {
                    // quality cannot be more than 50
                    if (item.quality < 50) {
                        // Increment item quality by 1.
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }
}