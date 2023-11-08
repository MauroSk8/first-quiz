package org.velezreyes.quiz.question6;

public class ScottCola implements Drink {

  @Override
  public String getName() {
    return "ScottCola";
  }

  @Override
  public boolean isFizzy() {
    return true; // ScottCola es una bebida carbonatada
  }
}
