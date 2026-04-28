import com.llogaauto.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GestorAutomobilsTest {

    GestorAutomobils gestor;

    @BeforeEach
    void setUp() {
        gestor = new GestorAutomobils();
    }

    @Test
    void testConstructorEmpty() {
        // Test constructor creates empty list
        assertFalse(gestor.existeixAutomobil("0000AAA"));
    }

    @Test
    void testAfegirAutomobil() {
        Cotxe cotxe = new Cotxe("BMW", "X1", "1234SDF", TipusCombustible.BENZINA_95, 5);
        gestor.afegirAutomobil(cotxe);
        assertTrue(gestor.existeixAutomobil("1234SDF"));
    }

    @Test
    void testAfegirDuplicate() {
        Cotxe cotxe1 = new Cotxe("Dup1", "Model", "2222BCD", TipusCombustible.DIESEL, 4);
        Cotxe cotxe2 = new Cotxe("Dup2", "Model", "2222BCD", TipusCombustible.DIESEL, 4); // same matricula different object
        gestor.afegirAutomobil(cotxe1);
        gestor.afegirAutomobil(cotxe2);
        assertTrue(gestor.existeixAutomobil("2222BCD")); // exists (allows duplicates by matricula?)
    }

    @Test
    void testAfegirNull() {
        gestor.afegirAutomobil(null);
        // null matricula won't match any existence check
    }

    @Test
    void testExisteixAutomobil() {
        Cotxe cotxe = new Cotxe("Test", "Model", "3333DEF", TipusCombustible.BENZINA_95, 5);
        gestor.afegirAutomobil(cotxe);
        assertTrue(gestor.existeixAutomobil("3333DEF"));
        assertFalse(gestor.existeixAutomobil("nonexistent"));
    }

    @Test
    void testEliminarAutomobilExisting() {
        Cotxe cotxe = new Cotxe("Rem", "Model", "4444FGH", TipusCombustible.ELECTRIC, 5);
        gestor.afegirAutomobil(cotxe);
        gestor.eliminarAutomobil("4444FGH");
        assertFalse(gestor.existeixAutomobil("4444FGH"));
    }

    @Test
    void testEliminarAutomobilEmptyList() {
        gestor.eliminarAutomobil("nonexist");
        // No crash, list stays empty
        assertFalse(gestor.existeixAutomobil("nonexist"));
    }

    @Test
    void testEliminarAutomobilNonExistent() {
        Cotxe cotxe = new Cotxe("Keep", "Model", "5555HIJ", TipusCombustible.HIBRID, 5);
        gestor.afegirAutomobil(cotxe);
        gestor.eliminarAutomobil("9999ZZZ");
        assertTrue(gestor.existeixAutomobil("5555HIJ"));
    }

    @Test
    void testEliminarMultiple() {
        Cotxe cot1 = new Cotxe("M1", "M", "6666KLM", TipusCombustible.BENZINA_98, 4);
        Camio cam1 = new Camio("M2", "M", "7777NOP", TipusCombustible.DIESEL, 1000, 10000);
        gestor.afegirAutomobil(cot1);
        gestor.afegirAutomobil(cam1);

        gestor.eliminarAutomobil("6666KLM");
        gestor.eliminarAutomobil("7777NOP");

        assertFalse(gestor.existeixAutomobil("6666KLM"));
        assertFalse(gestor.existeixAutomobil("7777NOP"));
    }

    @Test
    void testEliminarNull() {
        gestor.eliminarAutomobil(null);
        // No crash
    }

    @Test
    void testEliminarEmptyMatricula() {
        gestor.eliminarAutomobil("");
        // No crash
    }

    // Original tests preserved/adapted
    @Test
    void testOriginalExisteix() {
        Cotxe cot1 = new Cotxe("BMW", "X1", "1234SDF", TipusCombustible.BENZINA_95, 3);
        Cotxe cot2 = new Cotxe("BMW", "X1", "2222SDF", TipusCombustible.BENZINA_95, 3);
        gestor.afegirAutomobil(cot1);
        gestor.afegirAutomobil(cot2);
        assertTrue(gestor.existeixAutomobil("2222SDF"));
        assertFalse(gestor.existeixAutomobil("2322SDF"));
    }

    @Test
    void testOriginalEliminar() {
        Cotxe cot = new Cotxe("BMW", "X1", "1234SDF", TipusCombustible.BENZINA_95, 3);
        gestor.afegirAutomobil(cot);
        gestor.eliminarAutomobil("1234SDF");
        assertFalse(gestor.existeixAutomobil("1234SDF"));
    }
}

