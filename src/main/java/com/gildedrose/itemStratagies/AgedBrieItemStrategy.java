package com.gildedrose.itemStratagies;

import com.gildedrose.Item;

public class AgedBrieItemStrategy implements ItemStrategy  {
    @Override
    public Item updateItem(Item item) {
        int newQuality = sellInIsPassed(item) ? item.quality + 2 : item.quality + 1;

        if(isQualityGreaterThanFifty(newQuality)) {
            newQuality = 50;
        }

        return new Item(item.name, item.sellIn - 1, newQuality);
    }

    private boolean sellInIsPassed(Item item) {
        return item.sellIn < 1;
    }

    private boolean isQualityGreaterThanFifty(int newQuality) {
        return newQuality > 50;
    }
}
