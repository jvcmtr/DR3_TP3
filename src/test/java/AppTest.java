import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{

    @Test
    @DisplayName(" Somente Numeros que são maiores que 0.2 são bem sucedidos ")
    public void completarTarefa(){
        Job a = new Job(0.19999f);
        Job b = new Job(0.2f);
        Job c = new Job(0.20001f);

        assertTrue( !a.succeed() );
        assertTrue( b.succeed() );
        assertTrue( c.succeed() );
    }

    @Test
    @DisplayName(" A fila retorna o numero de tarefas mal sucedidas")
    public void testarRetornoDaFila(){
        JobQueue q = App.getTestJobQueue();
        assertEquals( q.resolveAll(), 2);
    }

    @Test
    @DisplayName(" A fila não é construida no caso de um argumento nulo")
    public void TestarConstrutorDaFila(){
        assertThrows(NullPointerException.class, ()->{
            JobQueue q = new JobQueue(null);
        });
    }

    @Test
    @DisplayName(" App é capaz de gerar filas aleatórias com consistência ")
    public void testarFila(){
        long total = 0;
        long errors = 0;

        for (int i = 0; i < 1000; i++) {
            JobQueue q = App.getRandomJobQueue();
            total += q.getJobs().length;
            errors += q.resolveAll();
        }

        float desvio = (float) errors /total;
        desvio = desvio - 0.2f;
        float margemAceitavel = 0.001f;

        assertTrue( desvio < margemAceitavel );
        assertTrue( desvio < (0-margemAceitavel));
        }


}



