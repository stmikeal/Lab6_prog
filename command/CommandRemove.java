package command;

import tools.Speaker;
import client.Client;
import element.Worker;
import java.util.TreeSet;

/**
 * Класс-команда remove_by_id
 *
 * @author mike
 */
public class CommandRemove extends Command{

    /**
     * Удаление элемента. Удаляет элемент по его id.
     *
     * @param console
     * @param args
     */
    
    private int id;
    
    public CommandRemove(String ... args) {
        ready = true;
        try {
            id = Integer.parseInt(args[1]);
        } catch(NumberFormatException e) {
            ready = false;
        }
    }
    
    @Override
    public Speaker event(TreeSet<Worker> collection) {
        Worker compared = collection.floor(new Worker(id)); 
        if(id == compared.getId()) {
            collection.remove(compared);
            speaker = new Speaker("Элемент удачно удален.");
            speaker.success();
            return speaker;
        } else {
            speaker = new Speaker("Элемент не найден.");
            speaker.error();
            return speaker;
        }
    }
}
