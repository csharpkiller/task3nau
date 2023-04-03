package Task2;

import java.util.HashMap;

public class TicketBase {

    /*
    * Выбор коллекции выпал на HashMap: наша задача - по ключу получить значение,
    * эта ф-я работает за O(1). Итерация по HashMap медленная, но она нам и не нужна.
    * */
    private HashMap<String, ProductSet> ticketArchive = new HashMap<>();

    public String getFoodInfo(String ticketNumber){
        ProductSet currentSet = ticketArchive.get(ticketNumber);
        if(currentSet == null) return "No have ticket";
        switch (currentSet){
            case DRINKS -> {
                return "Need drink";
            }
            case EAT_AND_DRINKS -> {
                return "Need drink and food";
            }
            case NOTHING -> {
                return "Nothing";
            }
            default -> {
               return null;
            }
        }
    }

    public void addTicketInArchive(String ticketNumber, ProductSet productSet){
        if(ticketArchive.containsKey(ticketNumber)){
            System.out.println("Ticket contains in base");
            return;
        }
        ticketArchive.put(ticketNumber, productSet);
    }

    public void resetArchive(){
        ticketArchive = new HashMap<>();
    }

}
