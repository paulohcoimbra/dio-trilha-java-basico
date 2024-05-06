import exceptions.ParametrosInvalidosException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContadorTest{
    @Test
    void ShouldCount() {
        assertDoesNotThrow(() -> Contador.contar(10, 15));
    }

    @Test
    void DeveLancarParametrosInvalidosException() {
        assertThrows(ParametrosInvalidosException.class, () -> Contador.contar(15, 10));
    }
}
