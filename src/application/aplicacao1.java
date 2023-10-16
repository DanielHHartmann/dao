package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.TesteDao;
import model.entities.Teste;

public class aplicacao1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        TesteDao testeDao = DaoFactory.createTesteDao();

        System.out.println("\n=== TEST 6: teste delete =====");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        testeDao.deleteById(id);
        System.out.println("Delete completed");


        Teste newTeste = new Teste(null, "Music");
        testeDao.insert(newTeste);
        System.out.println("Inserted! New id: " + newTeste.getId());

        System.out.println("=== TEST 1: findById =======");
        Teste dep = testeDao.findById(1);
        System.out.println(dep);

        sc.close();



    }
}
