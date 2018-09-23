package enumerations.vending_machine;

import utils.Generator;

public class RandomInputGenerator implements Generator<Input> {
  @Override
  public Input next() {
    return Input.randomSelection();
  }
}
