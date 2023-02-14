import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BonusServiceTest {

    BonusService service;

    @BeforeEach
    public void inicializar(){
        service = new BonusService();
    }

    @Test
    public void bonusDeveLancarExceptionParaSalariosMuitoAltosComAssertThrows(){
        //Abordagem 1
        assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(
                new Funcionario(
                        "Romão",
                        LocalDate.now(),
                        new BigDecimal("35000.00"))));
    }

    @Test
    public void bonusDeveLancarExceptionParaSalariosMuitoAltosComTryCatch(){
        //Abordagem 2
        try {
            service.calcularBonus(
                    new Funcionario(
                            "Romão",
                            LocalDate.now(),
                            new BigDecimal("35000.00")));
            fail("Não capturou a Exception");

        }catch (Exception e){
            assertEquals("Salário acima de 10k não tem direito à bonus", e.getMessage());
        }
    }

    @Test
    public void bonusDeveriaSerDezPorCentoDoSalario(){
        BigDecimal bonus = service.calcularBonus(
                new Funcionario(
                        "Romão",
                        LocalDate.now(),
                        new BigDecimal("2500.00")));

        assertEquals( new BigDecimal("250.00"), bonus );

    }

    @Test
    public void bonusDeveriaSerDezPorCentoQuandoSalarioForDezMil(){
        BigDecimal bonus = service.calcularBonus(
                new Funcionario(
                        "Romão",
                        LocalDate.now(),
                        new BigDecimal("10000.00")));

        assertEquals( new BigDecimal("1000.00"), bonus );

    }

}
