package task1;

abstract class Client {
    int id;
    String name;

    public abstract void addClient(Integer id, String name);

    public abstract String printNameById();

    public abstract int printIdByName();

    public abstract void printInfoClients();
}
