package TP3.Ejercicio1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GeneralTreeTest {

    private GeneralTree<Integer> root;
    private GeneralTree<Integer> leaf1;
    private GeneralTree<Integer> leaf2;

    @Before
    public void setUp() {
        // Crear un árbol de prueba
        root = new GeneralTree<>(10); // Usar el campo de la clase, no una variable local
        leaf1 = new GeneralTree<>(7);
        leaf2 = new GeneralTree<>(30);
        root.addChild(leaf1);
        root.addChild(leaf2);
        leaf1.addChild(new GeneralTree<>(18));
        GeneralTree<Integer> leaf3 = new GeneralTree<>(40); 
        root.addChild(leaf3);
        leaf3.addChild(new GeneralTree<>(45));
        GeneralTree<Integer> leaf4 = new GeneralTree<>(53);
        leaf3.addChild(leaf4);
        leaf3.addChild(new GeneralTree<>(68));
        leaf4.addChild(new GeneralTree<>(73));
    }

    @Test
    public void testNivelRaiz() {
        // El nivel del nodo raíz (10) debe ser 0
        assertEquals(0, root.nivel(10));
    }

    @Test
    public void testNivelHijo() {
        // El nivel del nodo 40 debe ser 1
        assertEquals(1, root.nivel(40));
    }

    @Test
    public void testNivelNieto() {
        // El nivel del nodo 45 debe ser 2
        assertEquals(2, root.nivel(45));
    }
    
    @Test
    public void testNivelBisNieto() {
        // El nivel del nodo 73 debe ser 3
        assertEquals(3, root.nivel(73));
    }

    @Test
    public void testNivelDatoNoExistente() {
        // Un dato que no está en el árbol debe retornar -1
        assertEquals(-1, root.nivel(99));
    }
    
    @Test
    public void testAncho() {
        // El ancho maximo del arbol de prueba es 4 (nivel con 4 nodos: 18, 45, 53, 68)
        assertEquals(4, root.ancho());
    }
    
    @Test
    public void testRemoveChild() {
        // Verificar que el hijo esté presente antes de la eliminación
        assertTrue(root.getChildren().contains(leaf1));
        assertTrue(root.getChildren().contains(leaf2));
        
        // Eliminar un hijo
        root.removeChild(leaf1);
        
        // Verificar que el hijo se haya eliminado
        assertFalse(root.getChildren().contains(leaf1));
        // Verificar que el otro hijo sigue presente
        assertTrue(root.getChildren().contains(leaf2));
    }
    
}
