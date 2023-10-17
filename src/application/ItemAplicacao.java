package application;

import java.sql.SQLOutput;
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
        int op = -1, id, ano, mes, dia, opu;
        String vDescricao,vCategoria,vMarca,vModelo,vNumeroSerie,vPotencia,vLocalizacao,vEnviado,vNotaFiscal;
        Date vDataEntrada,vUltimaQualificacao,vProximaQualifacao;

        while (op != 0){
            System.out.println("------Menu------");
            System.out.println("1) Buscar por id");
            System.out.println("2) Listar itens");
            System.out.println("3) Cadastrar novo item");
            System.out.println("4) Atualizar item");
            System.out.println("5) Deletar item");
            System.out.println("0) Sair\n");
            System.out.println("Insira a opção desejada: ");
            op = sc.nextInt();
            sc.nextLine();
            System.out.println("");

            switch (op){
                case 1:
                    System.out.println("----- Buscar -----");
                    System.out.println("Insira o id para buscar um item: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    Item item = itemDao.findById(id);
                    System.out.println(item);
                    break;
                case 2:
                    System.out.println("----- Lista de itens -----");
                    List<Item> list = itemDao.findAll();
                    for (Item d : list) {
                        System.out.println(d);
                    }
                    break;
                case 3:
                    System.out.println("----- Cadastrar -----");
                    System.out.println("Insira a descrição: ");
                    vDescricao = sc.nextLine();
                    System.out.println("Insira a categoria: ");
                    vCategoria = sc.nextLine();
                    System.out.println("Insira a marca: ");
                    vMarca = sc.nextLine();
                    System.out.println("Insira o modelo: ");
                    vModelo = sc.nextLine();
                    System.out.println("Insira o número de série: ");
                    vNumeroSerie = sc.nextLine();
                    System.out.println("Insira a potência: ");
                    vPotencia = sc.nextLine();
                    System.out.println("Insira a localização: ");
                    vLocalizacao = sc.nextLine();
                    System.out.println("Insira o estado de enviado: ");
                    vEnviado = sc.nextLine();
                    System.out.println("Insira a nota fiscal: ");
                    vNotaFiscal = sc.nextLine();
                    System.out.println("Insira o ano de entrada: ");
                    ano = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Insira o mes de entrada: ");
                    mes = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Insira o dia de entrada: ");
                    dia = sc.nextInt();
                    sc.nextLine();
                    ano = ano -1900;
                    vDataEntrada = new Date(ano,mes,dia);
                    System.out.println("Insira o ano da última qualificação: ");
                    ano = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Insira o mes da última qualificação: ");
                    mes = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Insira o dia da última qualificação: ");
                    dia = sc.nextInt();
                    sc.nextLine();
                    ano = ano -1900;
                    vUltimaQualificacao= new Date(ano,mes,dia);
                    System.out.println("Insira o ano da próxima qualificação: ");
                    ano = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Insira o mes da próxima qualificação: ");
                    mes = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Insira o dia da próxima qualificação: ");
                    dia = sc.nextInt();
                    sc.nextLine();
                    ano = ano -1900;
                    vProximaQualifacao= new Date(ano,mes,dia);

                    Item newItem = new Item(null,vDescricao,vCategoria,vMarca,vModelo,vNumeroSerie,vPotencia,vLocalizacao,vEnviado,vNotaFiscal, vDataEntrada, vUltimaQualificacao, vProximaQualifacao);

                    itemDao.insert(newItem);
                    System.out.println("Cadastrado! novo id: " + newItem.getId());

                    break;
                case 4:
                    opu = -1;
                    System.out.println("----- Atualizar -----");
                    System.out.println("Insira o id para buscar um item: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    item = itemDao.findById(id);
                    System.out.println(item);

                    System.out.println("----- Atributos -----");
                    System.out.println("1) Descrição");
                    System.out.println("2) Categoria");
                    System.out.println("3) Marca");
                    System.out.println("4) Modelo");
                    System.out.println("5) Número de Série");
                    System.out.println("6) Potência");
                    System.out.println("7) Localização");
                    System.out.println("8) Estado de enviado");
                    System.out.println("9) Nota fiscal");
                    System.out.println("10) Data de entrada");
                    System.out.println("11) Última qualificação");
                    System.out.println("12) Próxima qualificação");

                    while (opu != 0){
                        System.out.println("\nInsira opção que deseja atualizar ou 0 para parar a atualização: ");
                        opu = sc.nextInt();
                        sc.nextLine();

                        switch(opu){
                            case 1:
                                System.out.println("Insira a descrição: ");
                                vDescricao = sc.nextLine();
                                item.setDescricao(vDescricao);
                                break;
                            case 2:
                                System.out.println("Insira a categoria: ");
                                vCategoria = sc.nextLine();
                                item.setCategoria(vCategoria);
                                break;
                            case 3:
                                System.out.println("Insira a marca: ");
                                vMarca = sc.nextLine();
                                item.setMarca(vMarca);
                                break;
                            case 4:
                                System.out.println("Insira o modelo: ");
                                vModelo = sc.nextLine();
                                item.setModelo(vModelo);
                                break;
                            case 5:
                                System.out.println("Insira o número de série: ");
                                vNumeroSerie = sc.nextLine();
                                item.setNumeroSerie(vNumeroSerie);
                                break;
                            case 6:
                                System.out.println("Insira a potência: ");
                                vPotencia = sc.nextLine();
                                item.setPotencia(vPotencia);
                                break;
                            case 7:
                                System.out.println("Insira a localização: ");
                                vLocalizacao = sc.nextLine();
                                item.setLocalizacao(vLocalizacao);
                                break;
                            case 8:
                                System.out.println("Insira o estado de enviado: ");
                                vEnviado = sc.nextLine();
                                item.setEnviado(vEnviado);
                                break;
                            case 9:
                                System.out.println("Insira a nota fiscal: ");
                                vNotaFiscal = sc.nextLine();
                                item.setNotaFiscal(vNotaFiscal);
                                break;
                            case 10:
                                System.out.println("Insira o ano de entrada: ");
                                ano = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Insira o mes de entrada: ");
                                mes = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Insira o dia de entrada: ");
                                dia = sc.nextInt();
                                sc.nextLine();
                                ano = ano -1900;
                                vDataEntrada = new Date(ano,mes,dia);
                                item.setDataEntrada(vDataEntrada);
                                break;
                            case 11:
                                System.out.println("Insira o ano da última qualificação: ");
                                ano = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Insira o mes da última qualificação: ");
                                mes = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Insira o dia da última qualificação: ");
                                dia = sc.nextInt();
                                sc.nextLine();
                                ano = ano -1900;
                                vUltimaQualificacao= new Date(ano,mes,dia);
                                item.setUltimaQualificacao(vUltimaQualificacao);
                                break;
                            case 12:
                                System.out.println("Insira o ano da próxima qualificação: ");
                                ano = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Insira o mes da próxima qualificação: ");
                                mes = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Insira o dia da próxima qualificação: ");
                                dia = sc.nextInt();
                                sc.nextLine();
                                ano = ano -1900;
                                vProximaQualifacao= new Date(ano,mes,dia);
                                item.setProximaQualifacao(vProximaQualifacao);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Valor inserido não é aceito...");
                        };
                    }

                    itemDao.update(item);
                    System.out.println("Atualização completa!");

                    break;
                case 5:
                    System.out.println("----- Deletar -----");
                    System.out.println("Insira o id para deletar um item: ");
                    id = sc.nextInt();
                    itemDao.deleteById(id);
                    System.out.println("Item deletado");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Erro ao inserir opção...");
            }
            System.out.println("");


        }


        sc.close();

    }
}
