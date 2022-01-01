package com.company;

public class NumericNode extends Node {

  int value;

  public NumericNode(int value) {
    this.value = value;
  }

  @Override
  public int evaluate() {
    return (int)value;
  }

}
