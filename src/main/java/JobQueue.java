import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

// Equivalente à :
// private static final Logger LOGGER = LoggerFactory.getLogger(JobQueue.class);

@Slf4j
public class JobQueue {
    private Job[] Tarefas;
    public JobQueue(Job[] Jobs){
        if (Jobs == null){
            throw new NullPointerException( "O conteudo das das tarefas não pode ser NULL" ) ;
        }

        this.Tarefas = Jobs;
    }

    public int resolveAll(){
        log.info(">> Iniciando realização de tarefas : ");
        int i = 0;
        ArrayList<Float> erros = new ArrayList<Float>();

        for (Job tarefa : Tarefas) {
            if(tarefa.succeed()){
                log.info("Tarefa bem sucedida");
            }
            else{
                log.error("Tarefa não foi capaz de ser cumprida");
                erros.add(tarefa.getNumber());
                i++;
            }
        }
        log.info(">> FILA DE TAREFAS CONCLUIDA ! : ");
        log.error( i + " de " +  Tarefas.length + "tarefas não puderam ser cumpridas");
        log.debug("Tarefas que obtiveram falha: "+ erros.toString());

        return i;
    }



    public Job[] getJobs(){
        return Tarefas;
    }
}
