package com.company;

public class CustomerApplication {
    public static void main(String[] args) {
        Address shippingAddress = new Address("111", "12th St SE", "LA", "WA", 682007);
        Address billingAddress = new Address("Hummingbird", "6th Ave", "Seattle", "WA", 980078);
        Customer customer = new Customer("John", "Sam", "john@email.com","4251234567",shippingAddress, billingAddress, false);
        System.out.println(customer);
    }
}
