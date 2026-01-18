package model;

public record GroupData1(String name, String header, String footer) {
    public GroupData1(){
        this("", "", "");
    }

    public GroupData1 withName(String name) {
        return new GroupData1(name, this.header, this.footer);
    }

    public GroupData1 withHeader(String header) {
        return new GroupData1(this.name, header, this.footer);
    }

    public GroupData1 withFooter(String footer) {
        return new GroupData1(this.name, this.header, footer);
    }
}