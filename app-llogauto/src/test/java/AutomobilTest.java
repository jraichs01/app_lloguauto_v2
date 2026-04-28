import com.llogaauto.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// Classe de test per a la classe Automobil
public class AutomobilTest {
    
    // validem el format de la matrícula amb diferents casos de prova
    // casos vàlids
    @Test
    void testMatriculaValida() {
        assertTrue(Automobil.validarMatricula("1234LMN"));
        assertTrue(Automobil.validarMatricula("0000BBB"));
    }

    // casos invàlids
    @Test
    void testMatriculaInvalida() {
        assertFalse(Automobil.validarMatricula("1234ABC")); // Té vocals (A)
        assertFalse(Automobil.validarMatricula("123ABC4")); // Ordre incorrecte
        assertFalse(Automobil.validarMatricula("123BBB"));  // Falta un número
        assertFalse(Automobil.validarMatricula("1234BÑB")); // Lletra no permesa (Ñ)
    }

    // casos límit
    @Test
    void testValidarMatriculaNull() {
        assertFalse(Automobil.validarMatricula(null));
    }

    @Test
    void testValidarMatriculaEmpty() {
        assertFalse(Automobil.validarMatricula(""));
    }
}

