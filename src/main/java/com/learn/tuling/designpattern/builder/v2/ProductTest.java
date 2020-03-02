package com.learn.tuling.designpattern.builder.v2;

public class ProductTest {
    public static void main(String[] args) {
        Product.Builder builder = new Product.Builder().productName("xxx").companyName("c").part1("vv").part2("nn");

        builder.part3("part3");

        Product product = builder.build();

        System.out.println(product);
    }
}

class Product{

    private final String productName;
    private final String companyName;
    private final String part1;
    private final String part2;
    private final String part3;

    public Product(String productName, String companyName, String part1, String part2, String part3) {
        this.productName = productName;
        this.companyName = companyName;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
    }

    static class Builder{

        private  String productName;
        private  String companyName;
        private  String part1;
        private  String part2;
        private  String part3;

        public Builder productName(String productName){
            this.productName = productName;
            return this;
        }

        public Builder companyName(String companyName){
            this.companyName = companyName;
            return this;
        }

        public Builder part1(String part1){
            this.part1 = part1;
            return this;
        }

        public Builder part2(String part2){
            this.part2 = part2;
            return this;
        }

        public Builder part3(String part3){
            this.part3 = part3;
            return this;
        }

        public Product build() {
            return new Product(this.productName,this.companyName,this.part1,this.part2,this.part3);
        }

    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                '}';
    }
}