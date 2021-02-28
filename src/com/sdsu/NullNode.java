package com.sdsu;

public class NullNode extends AbstractNode {

  @Override
  public boolean isNull() {
    return true;
  }

  @Override
  public int getHeapHeight(AbstractNode node) {
    return 0;
  }
}