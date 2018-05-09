/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;


class Pizza {
    private String masa = "";
    private String salsa = "";
    private String relleno = "";
 
    public void setMasa(String masa)     { this.masa = masa; }
    public void setSalsa(String salsa)     { this.salsa = salsa; }
    public void setRelleno(String relleno) { this.relleno = relleno; }
}
 

abstract class PizzaBuilder {
    protected Pizza pizza;
 
    public Pizza getPizza() { return pizza; }
 
    public abstract void buildMasa();
    public abstract void buildSalsa();
    public abstract void buildRelleno();
}

class HawaiPizzaBuilder extends PizzaBuilder {
    public HawaiPizzaBuilder(){super.pizza = new Pizza();}
    public void buildMasa()   { pizza.setMasa("suave"); }
    public void buildSalsa()   { pizza.setSalsa("dulce"); }
    public void buildRelleno() { pizza.setRelleno("chorizo+alcachofas"); }
}

class PicantePizzaBuilder extends PizzaBuilder {
    public PicantePizzaBuilder(){super.pizza = new Pizza();}
    public void buildMasa()   { pizza.setMasa("cocida"); }
    public void buildSalsa()   { pizza.setSalsa("picante"); }
    public void buildRelleno() { pizza.setRelleno("pimienta+salchichón"); }
}
 
class Cocina {
    private PizzaBuilder pizzaBuilder;
 
    public void setPizzaBuilder(PizzaBuilder pb) { pizzaBuilder = pb; }
    public Pizza getPizza() { return pizzaBuilder.getPizza(); }
 
    public void construirPizza() {
       pizzaBuilder.buildMasa();
       pizzaBuilder.buildSalsa();
       pizzaBuilder.buildRelleno();
    }
}
 
 
/** Un cliente pidiendo una pizza. */
class BuilderExample {
    public static void main(String[] args) {
        Cocina cocina = new Cocina();
        PizzaBuilder hawai_pizzabuilder = new HawaiPizzaBuilder();
        PizzaBuilder picante_pizzabuilder = new PicantePizzaBuilder();
 
        cocina.setPizzaBuilder( hawai_pizzabuilder );
        cocina.construirPizza();
 
        Pizza pizza = cocina.getPizza();
    }
}

abstract class OtroPizzaBuilder {
    protected Pizza pizza;
 
    public Pizza getPizza() { return pizza; }
    public void crearNuevaPizza() { 
           pizza = new Pizza(); 
           buildMasa();
           buildSalsa();
           buildRelleno();
    }
 
    public abstract void buildMasa();
    public abstract void buildSalsa();
    public abstract void buildRelleno();
}

/** "Director" */
class OtraCocina {
    private OtroPizzaBuilder pizzaBuilder;
 

 
    public void construirPizza() {
       pizzaBuilder.crearNuevaPizza();
       //notar que no se necesita llamar a cada build.
    }
}
