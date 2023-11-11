package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(1, "нечто", 25);
    Product product2 = new Product(2, "нечто2", 25);
    Product product3 = new Product(3, "нечто3", 25);
    Product product4 = new Product(4, "нечто4", 25);
    Product product5 = new Product(5, "нечто5", 25);

    @Test
    public void successOfDeletingAnExistingElement() {
        ShopRepository current = new ShopRepository();
        current.add(product1);
        current.add(product2);
        current.add(product3);
        current.add(product4);
        current.add(product5);

        current.remove(3);

        Product[] expected = {product1, product2, product4, product5};
        Product[] actual = current.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void errorGeneration() {
        ShopRepository current = new ShopRepository();
        current.add(product1);
        current.add(product2);
        current.add(product3);
        current.add(product4);
        current.add(product5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            current.remove(10);
        });
    }

    @Test
    public void additionSuccess() {
        ShopRepository current = new ShopRepository();
        current.add(product1);
        current.add(product2);
        current.add(product3);
        current.add(product4);
        current.add(product5);

        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = current.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void errorGeneration2() {
        ShopRepository current = new ShopRepository();
        current.add(product1);
        current.add(product2);
        current.add(product3);
        current.add(product4);
        current.add(product5);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            current.add(product3);
        });
    }
}
