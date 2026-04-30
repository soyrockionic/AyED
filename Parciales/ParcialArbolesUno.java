package tp3.ejercicio1;

/*parcial
Implemente en la clase ParcialArboles el metodo: resolver (GeneralTree<String> arbol)
que recibe un arbol general de String y retorna el String mas largo que se encuentre mas
profundo en el arbol, junto con el String debe retornar el numero de nivel en el que se
encuentre el mismo. Si hubiese mas de un String con la misma longitud maxima a igual
profunddidad debe retornar uno de ellos.

Ejemplo:
Profesor
    ├─ Casa
    │   ├─ Un
    │   │   ├─ Reloj
    │   │   └─ Mariposa
    │   └─ Pan
    ├─ Lapiz
    ├─ Acolchado
    │   ├─ Puerta
    │   └─ Pececito
    │       └─ Escaleras
    └─ Cafe

Para el arbol dado, se debera retornar: "Escaleras" y nivel = 3.
Ya que la longitud maxima de los String es 9 y corresponde a:
"Acolchado" nivel 1
"Escaleras" nivel 3

"Acolchado" y "Escaleras" con la misma longitud, pero "Escaleras" es el que esta
a una profundidad mayor.

- Debe respetar la clase y el metodo indicado.
- Puede definir todos los metodos u variables auxiliares que considere.
- Todo aquel metodo que no este definido en las practicas debe ser implementado.
- Respetar el recorrido solicitado.
*/

public class ParcialArbolesUno {
    
    private static class InfoNodo {
        String nombre;
        int nivel;

        public InfoNodo(String nombre, int nivel) {
            this.nombre = nombre;
            this.nivel = nivel;
        }
        
       public String getNombre () {
           return this.nombre;
       }
       
       public int getNivel () {
           return this.nivel;
       }
       
       public String toString () {
           return this.nombre + " nivel " + this.nivel;
       } 
       
    }
    
    public InfoNodo resolver(GeneralTree<String> arbol) {
        if (arbol == null || arbol.isEmpty()) return null;
        InfoNodo masLargo = buscarLongMayor(arbol,0);
        return masLargo;
    }
    
    private InfoNodo buscarLongMayor (GeneralTree<String> nodo, int nivelActual) {
        
        InfoNodo maximo = new InfoNodo (nodo.getData(), nivelActual);      
        
        for (GeneralTree<String> hijo : nodo.getChildren()){
            InfoNodo maxHijo = buscarLongMayor(hijo, nivelActual + 1);
            if ( (maxHijo.nombre.length() > maximo.nombre.length()) || 
                 (maxHijo.nombre.length() == maximo.nombre.length() &&
                  maxHijo.nivel >= maximo.nivel) ) {
                maximo = maxHijo;
            }
        }
        return maximo;
    }
    
    public static void main(String[] args) {
        
        GeneralTree<String> arbol = new GeneralTree<>("Profesor");
        
        GeneralTree<String> hijo1 = new GeneralTree<>("Casa");
        GeneralTree<String> hijo2 = new GeneralTree<>("Lapiz");
        GeneralTree<String> hijo3 = new GeneralTree<>("Acolchado");
        GeneralTree<String> hijo4 = new GeneralTree<>("Cafe");
        
        arbol.addChild(hijo1);
        arbol.addChild(hijo2);
        arbol.addChild(hijo3);
        arbol.addChild(hijo4);
        
        GeneralTree<String> nieto1 = new GeneralTree<>("Un");
        GeneralTree<String> nieto2 = new GeneralTree<>("Pan");
        
        hijo1.addChild(nieto1);
        hijo1.addChild(nieto2);
        
        GeneralTree<String> nieto3 = new GeneralTree<>("Puerta");
        GeneralTree<String> nieto4 = new GeneralTree<>("Pececito");
        
        hijo3.addChild(nieto3);
        hijo3.addChild(nieto4);
        
        GeneralTree<String> bisnieto1 = new GeneralTree<>("Reloj");
        GeneralTree<String> bisnieto2 = new GeneralTree<>("Mariposa");
        
        nieto1.addChild(bisnieto1);
        nieto1.addChild(bisnieto2);
        
        GeneralTree<String> bisnieto3 = new GeneralTree<>("Escaleras");
        
        nieto4.addChild(bisnieto3);
        
        ParcialArbolesUno pa = new ParcialArbolesUno();
        
        System.out.println(pa.resolver(arbol));
        
        
    }
    
}