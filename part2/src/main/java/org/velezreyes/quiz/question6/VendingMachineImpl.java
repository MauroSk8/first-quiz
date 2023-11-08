package org.velezreyes.quiz.question6;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineImpl implements VendingMachine {

  private Map<String, Drink> inventory = new HashMap<>();
  private int totalMoney = 0;

  private VendingMachineImpl() {
    // Agregar bebidas al inventario
    Drink scottCola = new ScottCola();
    Drink karenTea = new KarenTea();

    addDrink(scottCola);
    addDrink(karenTea);
  }

  public static VendingMachine getInstance() {
    return new VendingMachineImpl();
  }

  @Override
  public void insertQuarter() {
    totalMoney += 25; // Cada inserción de un cuarto suma 25 centavos
  }

  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
    Drink drink = inventory.get(name);

    if (drink == null) {
      throw new UnknownDrinkException();
    }

    if (totalMoney < 75) {
      throw new NotEnoughMoneyException();
    }

    // Resta el costo de la bebida al dinero total
    totalMoney -= 75;

    // Devuelve la bebida seleccionada
    return drink;
  }

  public void addDrink(Drink drink) {
    inventory.put(drink.getName(), drink);
  }
}
