package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.ItemDao;
import model.entities.Item;
public class ItemAplicacao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ItemDao itemDao = DaoFactory.createItemDao();

        System.out.println();
        System.out.println("=== TEST 1: findById =======");
        Item item = itemDao.findById(1);
        System.out.println(item);

        System.out.println("\n=== TEST 2: findAll =======");
        List<Item> list = itemDao.findAll();
        for (Item d : list) {
            System.out.println(d);
        }

        System.out.println("\n=== TEST 3: insert =======");
        Item newItem = new Item(null,"A", "A","A","A","A","A","A","A","A", new Date(), new Date(), new Date());
        itemDao.insert(newItem);
        System.out.println("Inserted! New id: " + newItem.getId());

        System.out.println("\n=== TEST 5: seller update =====");
        item = itemDao.findById(2);
        item.setDescricao("Martha Waine");
        itemDao.update(item);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 6: seller delete =====");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        itemDao.deleteById(id);
        System.out.println("Delete completed");

        sc.close();

    }
}
