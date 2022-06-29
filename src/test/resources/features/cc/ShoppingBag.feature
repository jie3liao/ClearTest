Feature: Shop at www.ikea.com

    @AddToBag
    Scenario: Add items to shopping bag and validate items and discount code
        Given user is on Ikea shopping page
         When user types "sofa" in search bar to search
          And user picks number 1 position item in the list and puts the item in shopping bag
         When user types "table" in search bar to search 
          And user picks number 3 position item in the list and puts the item in shopping bag 
         When user click "Shopping bag" link on landing page
         Then verify 2 items in shopping bag
         When user clicks "Use a discount code" button in shopping bag
          And user enters 15 character string into "Discount code" field in shopping bag
          And user clicks "Apply discount" button in shopping bag
         Then validate that "invalid coupon code" error message is displayed in "discount code" message location in shopping bag
          