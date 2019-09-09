My solution in Java for the [GildedRose-Refactoring-Kata](https://github.com/emilybache/GildedRose-Refactoring-Kata) by EmilyBache.

#### First looks at the application
The Gilded Rose class has a method updateQuality() which at a glance seems to long. It then contains a lot of 
nested if-statements, repetitions, very long and complicated hard-coded strings, and small operations that is 
unclear.

The class Item has 3 fields, name, sellIn and quality, which define each of the item types. 

The application comes with a GildedRoseTest class with one failing test as well, ready to be ‘populated’ with 
further tests.

#### First step: understanding how the application works
Before making any changes to the application I should try to understand how the application works. To that 
end each line was analysed and comments on added and logic compared to the current specifications.

#### Second step: adding tests
Now the I understand what the code should do and before any changes are made a more comprehensive set of tests
are added. At this point a test is added for the required change but ignored in testing cycle for now.

It was now clear from the passing of the tests that the code worked as expected. 

#### Third step: starting refactoring
This phase is mainly about making the code more readable for the major refactoring to come. This involved the 
replace of the `for-loop` with the the enhanced for loop. This and a few other minor changes made it easier 
the coming changes.

#### Fourth step: major refactoring 
In simple terms based on an items name different logic was applied. There are a number of ways this
could be approached, leave as is, item Factory or Strategy patterns are just a few. Either way the item 
will need to be encapsulated to meet with the restrictions of no changes to Item class.

I elected to use the Strategy patterns approach as it seemed simpler. I like to keep things simple (K.I.S.S). Based 
the item name a strategy class will be supplied which carried out the calculations. This approach then allows for a 
default strategy class for non-specified names. This provided what was intended:

1. Simpler main method with complex logic moved to specific classes
2. Reduction of the large nested if statements
3. Large test coverage
4. Although less require the removal of long string statements in the logic

