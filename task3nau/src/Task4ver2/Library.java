package Task4ver2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Library {
    /*
    * Выбор пал на HashMap: за ключ берем год, значине - список книг
    * Благодаря этому мы можем быстро получить книги по интервалу.
    *  Поиск опредленной книги будет дольше,
    * но то что они разделены на группы не повлияет на поиск тк мы все равно делаем пробег по n эл-ам
    * */
    private final HashMap<String, LinkedList<Book>> lib = new HashMap<>();

    public void addBook(Book book){
        if(lib.containsKey(book.getYear())){
            lib.get(book.getYear()).add(book);
        }else {
            LinkedList<Book> books = new LinkedList<>();
            books.add(book);
            lib.put(book.getYear(), books);
        }
    }

    public void deleteBook(Book book){
        if(!lib.containsKey(book.getYear())){
            System.out.println("book dose-nt contains in lib");
        }
        else {
            LinkedList<Book> lst = lib.get(book.getYear());
            int count = 0;
            for (Book e: lst
                 ) {
                if(e.equals(book)) break;
                else count++;
            }
            lst.remove(count);
            lib.put(book.getYear(), lst);
        }
    }

    public List<Book> getBooks(RequestCriterion requestCriterion, String req) {
        switch (requestCriterion) {
            case PUB_YEAR -> {
                if (lib.containsKey(req)) return lib.get(req);
            }
            case AUTHOR -> {
                return authorReq(req);
            }
            case NAME -> {
                return nameReq(req);
            }
            case YEAR_DIAPASON -> {
                return diapasonReq(req);
            }
        }
        return null;
    }

    // 1941-1945
    private List<Book> diapasonReq(String req){
        String[] splt = req.split("-");
        int start = Integer.parseInt(splt[0]);
        int end = Integer.parseInt(splt[1]);
        LinkedList<Book> res = new LinkedList<>();
        for(int i = start; i <= end; i++){
            if(lib.containsKey(Integer.toString(i))) res.addAll(lib.get(Integer.toString(i)));
        }
        return res;
    }

    private List<Book> authorReq(String req){
        LinkedList<Book> result = new LinkedList<>();
        List<String> keys = new ArrayList<>(lib.keySet());
        for (String key : keys) {
            LinkedList<Book> books = lib.get(key);
            for (Book e : books
            ) {
                if (e.getAuthor().equals(req)) result.add(e);
            }
        }
        return result;
    }

    private List<Book> nameReq(String req){
        LinkedList<Book> result = new LinkedList<>();
        List<String> keys = new ArrayList<>(lib.keySet());
        for (String key : keys) {
            LinkedList<Book> books = lib.get(key);
            for (Book e : books
            ) {
                if (e.getName().equals(req)) result.add(e);
            }
        }
        return result;
    }
}
