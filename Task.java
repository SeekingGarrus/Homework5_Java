// Написать простой класс Телефонный Справочник (с помощью HashMap), который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
// Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
// тогда при запросе такой фамилии должны выводиться все телефоны.

import java.util.*;

class HomeWork3 {

    public static void main(String[] args) {
        task();
    }
    
    private static void task() {
        Directory directory = new Directory();
        
        directory.add("Ivanov", "8999999999");
        directory.add("Ivanov", "8912777777");
        directory.add("Petrov", "8917155555");
        directory.add("Petrov", "8987444444");
        directory.add("Antonov", "87666545355");
        directory.add("Sidorov", "89111111111");
        directory.add("Petrov", "89923231999");
        directory.add("Antonov", "88882222222");
        directory.add("Grigoryev", "84656454633");

        System.out.println(directory.get("Petrov"));
        System.out.println(directory.get("Antonov"));
        System.out.println(directory.get("Grigoryev"));
        System.out.println(directory.get("Ivanov"));
    }
}

class Directory {
    private Map<String, List<String>> directory_hm = new HashMap<>();
    private List<String> phone_number_list;

    public void add(String surname, String phone_number) {
        if (directory_hm.containsKey(surname)) {
            phone_number_list = directory_hm.get(surname);
            phone_number_list.add(phone_number);
            directory_hm.put(surname, phone_number_list);
        } else {
            phone_number_list = new ArrayList<>();
            phone_number_list.add(phone_number);
            directory_hm.put(surname, phone_number_list);
        }
    }

    public List<String> get(String surname) {
        return directory_hm.get(surname);
    }

}