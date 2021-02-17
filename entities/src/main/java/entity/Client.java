package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private int id;
    private String name;
    private double number;

    public Client(String name, double number) {
        this.name = name;
        this.number = number;
    }
}
