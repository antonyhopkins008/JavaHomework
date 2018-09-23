package enumerations.vending_machine;

import java.util.EnumMap;

import static enumerations.vending_machine.Input.*;

enum Category {
  MONEY(NICKEL, DIME, QUARTER, DOLLAR),
  ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
  QUIT_TRANSACTION(ABORT_TRANSACTION), SHUT_DOWN(STOP);
  private final Input[] values;
  Category(Input... types) {
    values = types;
  }
  private static EnumMap<Input, Category> categories = new EnumMap<>(Input.class);
  static {
    for (Category category : Category.class.getEnumConstants()) {
      for (Input type : category.values) {
        categories.put(type, category);
      }
    }
  }
  public static Category categorize(Input input) {
    return categories.get(input);
  }
}
