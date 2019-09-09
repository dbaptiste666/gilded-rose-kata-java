package com.gildedrose.itemStratagies;

import com.gildedrose.Item;

/**
 * The Strategy for Backstage Pass Item.
 */
public class BackstagePassItemStrategy implements ItemStrategy  {
    @Override
    public Item updateItem(Item item) {
        int newQuality;

        if(sellInIsPassed(item)) {
            newQuality = 0;
        } else if(sellInIsInFiveOrLessDays(item)) {
            newQuality = item.quality + 3;
        } else if(sellInIsInTenOrLessDays(item)) {
            newQuality = item.quality + 2;
        } else {
            newQuality = item.quality + 1;
        }

        if(isQualityGreaterThanFifty(newQuality)) {
            newQuality = 50;
        }

        return new Item(item.name, item.sellIn - 1, newQuality);
    }

    /**
     * @param item
     * @return boolean
     */
    private boolean sellInIsPassed(Item item) {
        return item.sellIn < 1;
    }

    /**
     * @param item
     * @return boolean
     */
    private boolean sellInIsInTenOrLessDays(Item item) {
        return item.sellIn < 11;
    }

    /**
     * @param item
     * @return boolean
     */
    private boolean sellInIsInFiveOrLessDays(Item item) {
        return item.sellIn < 6;
    }

    /**
     * @param newQuality
     * @return boolean
     */
    private boolean isQualityGreaterThanFifty(int newQuality) {
        return newQuality > 50;
    }
}
