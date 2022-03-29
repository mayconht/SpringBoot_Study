package com.estudos.spring;

import com.estudos.spring.domain.*;
import com.estudos.spring.domain.enums.PaymentStatus;
import com.estudos.spring.domain.enums.ClientType;
import com.estudos.spring.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CategoryRepository catRepo;
    @Autowired
    private ProductRepository prodRepo;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ItemOrderRepository itemOrderRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//	 	Only use with H2 database (temporary data)
//        SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//
//        Category cat1 = new Category(null, "Informática");
//        Category cat2 = new Category(null, "Escritório");
//
//        Product p1 = new Product(null, "Impressora", 800.00);
//        Product p2 = new Product(null, "Mouse", 300.00);
//        Product p3 = new Product(null, "Teclado", 150.00);
//
//        cat1.getProduct().addAll(Arrays.asList(p1, p2, p3));
//        cat2.getProduct().addAll(List.of(p1));
//
//        p1.getCategory().addAll(Arrays.asList(cat1, cat2));
//        p2.getCategory().addAll(List.of(cat1));
//        p3.getCategory().addAll(List.of(cat1));
//
//        catRepo.saveAll(Arrays.asList(cat1, cat2));
//        prodRepo.saveAll(Arrays.asList(p1, p2, p3));
//
//        State est1 = new State(null, "Espírito Santo", "ES");
//
//        City cid1 = new City(null, "Alegre", est1);
//
//        Client cli1 = new Client(null, "maycon douglas", "maycondss@live.com", "45852336859", ClientType.NATURALPERSON);
//        cli1.getPhone().addAll(Arrays.asList("+551530313161", "+556230343312"));
//
//        Address end1 = new Address(null, "Rua sei la das quantas", "300", null, "Jardiam", "3856125", cli1, cid1);
//        Address end2 = new Address(null, "Rua sei la dasaaaaaa quantas", "300s", null, "Jardim", "3856125", cli1, cid1);
//
//        cli1.getAddress().addAll(Arrays.asList(end1, end2));
//
//        stateRepository.saveAll(List.of(est1));
//        cityRepository.saveAll(List.of(cid1));
//        clientRepository.saveAll(List.of(cli1));
//        addressRepository.saveAll(Arrays.asList(end1, end2));
//
//        Order ped1 = new Order(null, sdt.parse("30/09/2022 10:20"), cli1, end1);
//        Payment pag1 = new CardPayment(null, PaymentStatus.PAID, ped1, 6);
//
//        ped1.setPagamento(pag1);
//        cli1.getOrders().addAll(List.of(ped1));
//
//        orderRepository.saveAll(List.of(ped1));
//        paymentRepository.saveAll(List.of(pag1));
//
//        ItemOrder ip1 = new ItemOrder(ped1, p1, 00.00, 1, 800.00);
//        ItemOrder ip2 = new ItemOrder(ped1, p3, 00.00, 2, 600.00);
//
//        ped1.getItems().addAll(Arrays.asList(ip1, ip2));
//
//        itemOrderRepository.saveAll(Arrays.asList(ip1, ip2));

    }
}
