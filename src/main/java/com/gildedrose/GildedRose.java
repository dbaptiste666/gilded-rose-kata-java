package com.gildedrose;

import com.gildedrose.itemStratagies.*;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    Item[] items;

    static Map<String, ItemStrategy> itemStrategyMap = new HashMap<>();

    public final static String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public final static String BRIE = "Aged Brie";
    public final static String BACKSTAGE_PASSES_ITEM = "Backstage passes to a TAFKAL80ETC concert";
    public final static String CONJURED_ITEM = "Conjured";

    static {
        itemStrategyMap.put(BRIE, new AgedBrieItemStrategy());
        itemStrategyMap.put(SULFURAS, new SulfurasItemStrategy());
        itemStrategyMap.put(BACKSTAGE_PASSES_ITEM, new BackstagePassItemStrategy());
        itemStrategyMap.put(CONJURED_ITEM, new ConjuredItemStrategy());
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    // assumed called daily
    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {
            ItemStrategy itemStrategy = itemStrategyMap.getOrDefault(items[i].name, new NormalItemStrategy());
            items[i] = itemStrategy.updateItem(items[i]);
        }
    }
}