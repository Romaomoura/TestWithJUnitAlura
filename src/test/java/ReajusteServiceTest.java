import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar(){
        service = new ReajusteService();
        funcionario = new Funcionario("Amanda",LocalDate.now(),new BigDecimal("1000.00"));
    }

    @Test
    public void reajusteDeveriaSerDeTresPorCentoComDesempenhoForADesejar(){
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals( new BigDecimal("1030.00"), funcionario.getSalario() );

    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorCentoComDesempenhoForBom(){
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals( new BigDecimal("1150.00"), funcionario.getSalario() );

    }

    @Test
    public void reajusteDeveriaSerDeVintePorCentoComDesempenhoForOtimo(){
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals( new BigDecimal("1200.00"), funcionario.getSalario() );

    }
}
