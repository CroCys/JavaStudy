package Spring.bean;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Printer {
    private Toner toner;

    public void print(String text) {
        if (toner == null) {
            System.out.println("No toner set");
        }

        if (text == null) {
            System.out.println("No text set");
        }

        if (toner != null && text != null) {
            toner.setCapacity(toner.getCapacity() - 10);
            System.out.println(text);
            System.out.println(toner.getColor() + " toner capacity = " + getTonerCapacity());
        }
    }

    public String getTonerColor() {
        return toner.getColor();
    }

    public int getTonerCapacity() {
        return toner.getCapacity();
    }

    public void changeToner(Toner toner) {
        this.toner = toner;
    }
}
