import java.util.ArrayList;

public class MenuRegister {
    private final ArrayList<Menu> menus = new ArrayList<>();
    private final ArrayList<Dish> dishes = new ArrayList<>();

    public Menu addMenu(String name, Dish[] dishes) {
        Menu m = new Menu(name);

        for(Dish d : dishes) {
            m.addDish(d);
        }

        menus.add(m);
        return m;
    }

    public Menu addMenu(Dish[] dishes) {
        Menu m = new Menu();

        for(Dish d : dishes) {
            m.addDish(d);
        }

        menus.add(m);
        return m;
    }

    public Menu[] getMenusByTotalPrice(int priceMin, int priceMax) {
        ArrayList<Menu> result = new ArrayList<>();

        for(Menu m : menus) {
            int total = 0;

            for(Dish d : m.getDishes()) {
                total += d.getPrice();
            }

            if(total >= priceMin && total <= priceMax) {
                result.add(m);
            }
        }

        return result.toArray(new Menu[0]);
    }

    public Dish addDish(String name, String type, int price) {
        Dish d = new Dish(name, type, price);
        dishes.add(d);
        return d;
    }

    public Dish getDishByName(String name) {
        for(Dish d : dishes) {
            if(d.getName().equals(name))
                return d;
        }
        throw new IllegalArgumentException("The given dish name does not exist.");
    }

    public Dish[] getDishesByType(String type) {
        ArrayList<Dish> result = new ArrayList<>();

        for(Dish d : dishes) {
            if(d.getType().equals(type)) {
                result.add(d);
            }
        }

        return result.toArray(new Dish[0]);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("Menus:\n\n");
        for(Menu m : menus) {
            result.append(String.format("\"%s\":%n", m.getName()));
            for(Dish d : m.getDishes()) {
                result.append(String.format("Name: %s, type: %s, price: %s%n", d.getName(), d.getType(), d.getPrice()));
            }
            result.append("\n\n");
        }

        result.append("Dishes:\n\n");

        for(Dish d : dishes) {
            result.append(String.format("Name: %s, type: %s, price: %s%n", d.getName(), d.getType(), d.getPrice()));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        MenuRegister mr = new MenuRegister();
        mr.addDish("Ice cream", "Dessert", 10);
        mr.getDishByName("Ice cream");
        mr.addDish("Popsicle", "Dessert", 4);
        mr.addDish("Oreo cake", "Dessert", 20);
        mr.addDish("Chocolate cake", "Dessert", 15);

        Dish pz = mr.addDish("Pizza", "Main course", 30);
        mr.addDish("Burger", "Main course", 28);
        mr.addMenu(new Dish[]{pz, mr.getDishByName("Burger")});

        mr.addMenu("Desserts", mr.getDishesByType("Dessert"));

        System.out.println(mr.toString());
    }
}

class Menu {
    private final String name;
    private final ArrayList<Dish> dishes = new ArrayList<>();

    public Menu() {
        this.name = "Unnamed menu";
    }

    public Menu(String name) {
        this.name = name;
    }

    public void addDish(Dish d) {
        dishes.add(d);
    }

    public Dish[] getDishes() {
        return dishes.toArray(new Dish[0]);
    }

    public String getName() {
        return name;
    }
}

class Dish {
    private final String name;
    private final String type;
    private final int price;

    public Dish(String name, String type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Dish(Dish d) {
        this.name = d.getName();
        this.type = d.getType();
        this.price = d.getPrice();
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }
}