// Interface que define o contrato para as pizzas
interface Pizza {
    String getDescription();
    double cost();
}

// Implementação das pizzas concretas
class Margherita implements Pizza {
    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }

    @Override
    public double cost() {
        return 8.99;
    }
}

class Pepperoni implements Pizza {
    @Override
    public String getDescription() {
        return "Pepperoni Pizza";
    }

    @Override
    public double cost() {
        return 10.99;
    }
}

// Padrão Decorator para adicionar ingredientes extras
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double cost() {
        return pizza.cost();
    }
}

class ExtraCheeseDecorator extends PizzaDecorator {
    public ExtraCheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Queijao gay";
    }

    @Override
    public double cost() {
        return super.cost() + 2.50;
    }
}

// Padrão Bridge para criar diferentes tipos de pizzas com diferentes ingredientes
interface PizzaIngredient {
    String getIngredientDescription();
}

class ThinCrust implements PizzaIngredient {
    @Override
    public String getIngredientDescription() {
        return "Thin Crust";
    }
}

class ThickCrust implements PizzaIngredient {
    @Override
    public String getIngredientDescription() {
        return "bordona";
    }
}

class StuffedCrust implements PizzaIngredient {
    @Override
    public String getIngredientDescription() {
        return "coisas";
    }
}

// Adapter para criar pizzas a partir de ingredientes
class PizzaAdapter implements Pizza {
    private PizzaIngredient ingredient;

    public PizzaAdapter(PizzaIngredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String getDescription() {
        return ingredient.getIngredientDescription() + " Pizza";
    }

    @Override
    public double cost() {
        return 9.99; // Custo base
    }
}

// Classe principal para interação via linha de comando
public class PizzaOrderSystem {
    public static void main(String[] args) {
        System.out.println("Bem-vindo ao sistema de pedidos de pizza!");

        // Exemplo de pedido de pizza com diferentes ingredientes e decorações
        Pizza pizza1 = new ExtraCheeseDecorator(new PizzaAdapter(new ThinCrust()));
        System.out.println("Pedido: " + pizza1.getDescription());
        System.out.println("Custo: $" + pizza1.cost());

        Pizza pizza2 = new PizzaAdapter(new StuffedCrust());
        System.out.println("\nPedido: " + pizza2.getDescription());
        System.out.println("Custo: $" + pizza2.cost());
    }
}
