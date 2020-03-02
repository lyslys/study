package com.learn.tuling.designpattern.builder;

/**
 * 建造者模式
 */
public class BuilderTest {
    public static void main(String[] args) {

        ProductBuilder specialConcreteProductBuilder = new SpecialConcreteProductBuilder();

        Director director = new Director(specialConcreteProductBuilder);
        Product product = director.makeProduct("productNamexxx","companyNamexxx","part1","part2","part3");
        System.out.println(product);


    }
}

interface ProductBuilder{

    void builderProductName(String productName);
    void builderCompanyName(String companyName);
    void builderPart1(String part1);
    void builderPart2(String part2);
    void builderPart3(String part3);

    Product build();

}

class DefaultConcreteProductBuilder implements ProductBuilder {

    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;

    @Override
    public void builderProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void builderCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void builderPart1(String part1) {
        this.part1 = part1;
    }

    @Override
    public void builderPart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public void builderPart3(String part3) {
        this.part3 = part3;
    }

    @Override
    public Product build() {
        return new Product(this.productName,this.companyName,this.part1,this.part2,this.part3);
    }

}

class SpecialConcreteProductBuilder implements ProductBuilder {

    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;

    @Override
    public void builderProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void builderCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void builderPart1(String part1) {
        this.part1 = part1;
    }

    @Override
    public void builderPart2(String part2) {
        this.part2 = part2;
    }

    @Override
    public void builderPart3(String part3) {
        this.part3 = part3;
    }

    @Override
    public Product build() {
        return new Product(this.productName,this.companyName,this.part1,this.part2,this.part3);
    }

}

class Director{

    private ProductBuilder productBuilder;

    public Director(ProductBuilder productBuilder) {
        this.productBuilder = productBuilder;
    }

    public Product makeProduct(String productName, String companyName, String part1, String part2, String part3){
        productBuilder.builderProductName(productName);
        productBuilder.builderCompanyName(companyName);
        productBuilder.builderPart1(part1);
        productBuilder.builderPart2(part2);
        productBuilder.builderPart3(part3);

        Product product = productBuilder.build();
        return product;
    }

}

class Product{

    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;

    public Product() {
    }

    public Product(String productName, String companyName, String part1, String part2, String part3) {
        this.productName = productName;
        this.companyName = companyName;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public String getPart3() {
        return part3;
    }

    public void setPart3(String part3) {
        this.part3 = part3;
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