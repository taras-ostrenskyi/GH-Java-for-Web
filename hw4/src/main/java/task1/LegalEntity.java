package task1;

public class LegalEntity extends Client {
    private final String ownerSurname;

    public LegalEntity(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }

    @Override
    public void addClient(Integer id, String name) {

    }

    @Override
    public String printNameById() {
        return null;
    }

    @Override
    public int printIdByName() {
        return 0;
    }

    @Override
    public void printInfoAllclients() {

    }
}
