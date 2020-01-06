package com.learn.tuling.factory;

public class AbstractFactoryTest {

    public static void main(String[] args) {

        IDBComponent idbComponent = new MysqlDBComponent();
//        IDBComponent idbComponent = new OralceDBComponent();

        IConnection connection = idbComponent.getConnection();
        connection.connection();

        ICommand command = idbComponent.getCommand();
        command.command();

    }

}

interface IConnection{
    void connection();
}

interface ICommand{
    void command();
}

interface IDBComponent{
    IConnection getConnection();
    ICommand getCommand();
}


class MysqlConnection implements IConnection{

    @Override
    public void connection() {
        System.out.println("MysqlConnection connection run");
    }

}

class MysqlCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("MysqlCommand command run");
    }

}

class MysqlDBComponent implements IDBComponent{

    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }

}

class OralceConnection implements IConnection{

    @Override
    public void connection() {
        System.out.println("OralceConnection connection run");
    }

}

class OralceCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("OralceCommand command");
    }

}

class OralceDBComponent implements IDBComponent{

    @Override
    public IConnection getConnection() {
        return new OralceConnection();
    }

    @Override
    public ICommand getCommand() {
        return new OralceCommand();
    }
}