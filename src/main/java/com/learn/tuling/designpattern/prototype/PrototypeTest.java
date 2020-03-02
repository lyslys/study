package com.learn.tuling.designpattern.prototype;

public class PrototypeTest {
    public static void main(String[] args) throws Exception {

        Product product = new Product("productNamexxx", "companyNamexxx", "part1", "part2", "part3",new BaseInfo("66"));
        Product p = product.clone();
        p.setProductName("888");

        System.out.println(p == product);
        System.out.println(product.getProductName());

        System.out.println("----->");

        System.out.println(product);
        System.out.println(p);

        System.out.println(p.getBaseInfo()==product.getBaseInfo());

        System.out.println(System.identityHashCode(p.getBaseInfo()));
        System.out.println(System.identityHashCode(product.getBaseInfo()));

        product.getBaseInfo().setBaseInfoName("666666");
        System.out.println(product);
        System.out.println(p);


    }
}

class BaseInfo implements Cloneable{

    private String baseInfoName;

    public BaseInfo(String baseInfoName) {
        this.baseInfoName = baseInfoName;
    }

    public String getBaseInfoName() {
        return baseInfoName;
    }

    public void setBaseInfoName(String baseInfoName) {
        this.baseInfoName = baseInfoName;
    }

    @Override
    public String toString() {
        return hashCode()+" BaseInfo{" +
                "baseInfoName='" + baseInfoName + '\'' +
                '}';
    }

    @Override
    protected BaseInfo clone() throws CloneNotSupportedException {
        return (BaseInfo)super.clone();
    }
}

class Product implements Cloneable {

    private String productName;
    private String companyName;
    private String part1;
    private String part2;
    private String part3;
    private BaseInfo baseInfo;

    public Product() {
    }

    public Product(String productName, String companyName, String part1, String part2, String part3,BaseInfo baseInfo) {
        this.productName = productName;
        this.companyName = companyName;
        this.part1 = part1;
        this.part2 = part2;
        this.part3 = part3;
        this.baseInfo = baseInfo;
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

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    @Override
    public String toString() {
        return  hashCode()+"Product{" +
                "productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", baseInfo=" + baseInfo +
                '}';
    }

    @Override
    protected Product clone() throws CloneNotSupportedException {
        Product clone = (Product) super.clone();
        BaseInfo baseInfo = this.baseInfo.clone();
        clone.setBaseInfo(baseInfo);
        return clone;
    }
}
