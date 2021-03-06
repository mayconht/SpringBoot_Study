package com.estudos.spring;

import com.estudos.spring.domain.Address;
import com.estudos.spring.domain.CardPayment;
import com.estudos.spring.domain.Category;
import com.estudos.spring.domain.City;
import com.estudos.spring.domain.Client;
import com.estudos.spring.domain.ClientOrder;
import com.estudos.spring.domain.ItemOrder;
import com.estudos.spring.domain.Payment;
import com.estudos.spring.domain.Product;
import com.estudos.spring.domain.State;
import com.estudos.spring.domain.enums.ClientType;
import com.estudos.spring.domain.enums.PaymentStatus;
import com.estudos.spring.repositories.AddressRepository;
import com.estudos.spring.repositories.CategoryRepository;
import com.estudos.spring.repositories.CityRepository;
import com.estudos.spring.repositories.ClientRepository;
import com.estudos.spring.repositories.ItemOrderRepository;
import com.estudos.spring.repositories.OrderRepository;
import com.estudos.spring.repositories.PaymentRepository;
import com.estudos.spring.repositories.ProductRepository;
import com.estudos.spring.repositories.StateRepository;
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

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
//	 	Only use with H2 database (temporary data)
        final SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        final Category cat1 = new Category(null, "Inform??tica");
        final Category cat2 = new Category(null, "Escrit??rio");

        final Product p1 = new Product(null, "Impressora", 800.00);
        final Product p2 = new Product(null, "Mouse", 300.00);
        final Product p3 = new Product(null, "Teclado", 150.00);

        cat1.getProduct().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProduct().addAll(List.of(p1));

        p1.getCategory().addAll(Arrays.asList(cat1, cat2));
        p2.getCategory().addAll(List.of(cat1));
        p3.getCategory().addAll(List.of(cat1));

        catRepo.saveAll(Arrays.asList(cat1, cat2));
        prodRepo.saveAll(Arrays.asList(p1, p2, p3));

        final State est1 = new State(null, "Esp??rito Santo", "ES");

        final City cid1 = new City(null, "Alegre", est1);

        final Client cli1 = new Client(null, "maycon douglas", "maycondss@live.com", "45852336859", ClientType.NATURALPERSON);
        cli1.getPhone().addAll(Arrays.asList("+551530313161", "+556230343312"));

        final Address end1 = new Address(null, "Rua sei la das quantas", "300", null, "Jardiam", "3856125", cli1, cid1);
        final Address end2 = new Address(null, "Rua sei la dasaaaaaa quantas", "300s", null, "Jardim", "3856125", cli1, cid1);

        cli1.getAddress().addAll(Arrays.asList(end1, end2));

        stateRepository.saveAll(List.of(est1));
        cityRepository.saveAll(List.of(cid1));
        clientRepository.saveAll(List.of(cli1));
        addressRepository.saveAll(Arrays.asList(end1, end2));

        final ClientOrder ped1 = new ClientOrder(null, sdt.parse("30/09/2022 10:20"), cli1, end1);
        final Payment pag1 = new CardPayment(null, PaymentStatus.PAID, ped1, 6);

        ped1.setPayment(pag1);
        cli1.getOrders().addAll(List.of(ped1));

        orderRepository.saveAll(List.of(ped1));
        paymentRepository.saveAll(List.of(pag1));

        final ItemOrder ip1 = new ItemOrder(ped1, p1, 00.00, 1, 800.00);
        final ItemOrder ip2 = new ItemOrder(ped1, p3, 00.00, 2, 600.00);

        ped1.getItems().addAll(Arrays.asList(ip1, ip2));

        itemOrderRepository.saveAll(Arrays.asList(ip1, ip2));

    }
}
